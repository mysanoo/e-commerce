package com.example.order_server.payment;

import com.example.order_server.customer.CustomerResponse;
import com.example.order_server.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
