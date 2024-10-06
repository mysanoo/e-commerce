package com.example.order_server.orderline;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository repository;

    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var order = new OrderLine(orderLineRequest);
        return repository.save(order).getId();
    }

    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return repository.findAllByOrderId(orderId)
                .stream()
                .map(OrderLineResponse::new)
                .toList();
    }
}
