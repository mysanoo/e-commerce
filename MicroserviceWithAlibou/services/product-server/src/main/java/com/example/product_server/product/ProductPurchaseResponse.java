package com.example.product_server.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductPurchaseResponse {
    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;

    public ProductPurchaseResponse(Product product, Integer quantity) {
        this.productId = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.quantity = quantity;
    }
}
