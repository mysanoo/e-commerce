package com.example.payment_server.notification;

import com.example.payment_server.payment.PaymentMethod;
import com.example.payment_server.payment.PaymentRequest;

import java.math.BigDecimal;

public record PaymentNotificationRequest (
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String costumerName,
        String costumerLastname,
        String email
){
}
