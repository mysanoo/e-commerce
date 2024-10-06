package com.example.order_server.orderline;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderLineRequest(
        Integer id,
        Integer orderId,
        @NotNull(message = "Product is mandatory")
        Integer productId,
        @Positive(message = "Product quantity should be positive")
        Integer quantity
) {
}

