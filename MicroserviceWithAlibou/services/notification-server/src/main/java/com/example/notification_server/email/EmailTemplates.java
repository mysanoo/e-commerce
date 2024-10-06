package com.example.notification_server.email;

import lombok.Getter;

public enum EmailTemplates {
    PAYMENT_CONFIRMATION("payment_confirmation.html", "Payment successfully processed"),
    ORDER_CONFIRMATION("order_confirmation.html", "Order confirmation");

    @Getter
    private final String template;
    @Getter
    private final String subject;

    EmailTemplates(String templates, String subject){
        this.template = templates;
        this.subject = subject;
    }
}
