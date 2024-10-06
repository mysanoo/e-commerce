package com.example.order_server.customer;

public record CustomerResponse(
        String customerId,
        String firstname,
        String lastname,
        String email

) {
}
