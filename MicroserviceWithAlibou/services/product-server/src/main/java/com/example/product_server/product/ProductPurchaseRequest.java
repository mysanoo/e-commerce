package com.example.product_server.product;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductPurchaseRequest {

    @NotNull(message = "Product id is mandatory")
    private Integer productId;
    @NotNull(message = "Product quantity is mandatory")
    private Integer quantity;
}
