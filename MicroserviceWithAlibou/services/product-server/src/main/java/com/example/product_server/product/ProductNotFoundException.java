package com.example.product_server.product;

import lombok.AllArgsConstructor;


public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
