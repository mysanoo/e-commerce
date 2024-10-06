package com.example.product_server.product;

import com.example.product_server.category.Category;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductResponse{
        private Integer id;
        private String name;
        private String description;
        private BigDecimal price;
        private Integer availableQuantity;
        private Integer categoryId;
        private String categoryName;
        private String categoryDescription;

        public ProductResponse(Product product){
            this.id = product.getId();
            this.name = product.getName();
            this.description = product.getDescription();
            this.price = product.getPrice();
            this.availableQuantity = product.getAvailableQuantity();
            this.categoryId = product.getCategory().getId();
            this.categoryName = product.getCategory().getName();
            this.categoryDescription = product.getCategory().getDescription();
        }
}
