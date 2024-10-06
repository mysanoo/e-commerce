package com.example.order_server.order;

import com.example.order_server.customer.CustomerClient;
import com.example.order_server.exception.BusinessException;
import com.example.order_server.kafka.OrderConfirmation;
import com.example.order_server.kafka.OrderProducer;
import com.example.order_server.orderline.OrderLineRequest;
import com.example.order_server.orderline.OrderLineService;
import com.example.order_server.payment.PaymentClient;
import com.example.order_server.payment.PaymentRequest;
import com.example.order_server.product.ProductClient;
import com.example.order_server.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;


    public Integer createOrder(OrderRequest request) {
        //check customer -> OpenFeign

        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException(""));

        //purchase the products -> product (RestTemplate)

        var purchasedProducts = productClient.purchaseProducts(request.products());

        //persist order

        var order = orderRepository.save(new Order(request));

        //persist order lines

        for (PurchaseRequest product : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            product.productId(),
                            product.quantity()
                    )
            );
        }

        //start payment process
        paymentClient.requestOrderPayment(new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                order.getId(),
                request.reference(),
                customer
        ));

        //send order confirmation to notification-ms (kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(OrderResponse::new)
                .toList();
    }

    public OrderResponse findById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(OrderResponse::new)
                .orElseThrow(() -> new EntityNotFoundException(format("No Order found with the provided ID: %id", orderId)));
    }


}
