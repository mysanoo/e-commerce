package com.example.order_server.product;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PurchaseResponse {

    private Integer productId;
    private String description;
    private BigDecimal price;
    private Integer quantity;
}
