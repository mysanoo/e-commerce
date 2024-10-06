package com.example.order_server.kafka;

import com.example.order_server.customer.CustomerResponse;
import com.example.order_server.order.PaymentMethod;
import com.example.order_server.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
