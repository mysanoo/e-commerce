package com.example.product_server.product;

import com.example.product_server.category.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        Integer id,
        @NotNull(message = "Product name is required")
        String name,
        @NotNull(message = "Product description is required")
        String description,
        @Positive(message = "Product price should be positive")
        BigDecimal price,
        @Positive(message = "Available quantity should be positive")
        Integer availableQuantity,
        @NotNull(message = "product category is required")
        Category category
) {
}
