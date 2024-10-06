package com.example.notification_server.kafka.payment;

import java.math.BigDecimal;

public record PaymentConfirmation(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String costumerName,
        String costumerLastname,
        String email
) {
}
