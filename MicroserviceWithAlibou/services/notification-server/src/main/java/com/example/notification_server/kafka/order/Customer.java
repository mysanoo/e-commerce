package com.example.notification_server.kafka.order;

public record Customer(
    String id,
    String firstname,
    String lastname,
    String email
){
}
