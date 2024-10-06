package com.example.product_server.product;

import com.example.product_server.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private Integer availableQuantity;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(ProductRequest request){
        this.name = request.name();
        this.price = request.price();
        this.description = request.description();
        this.availableQuantity = request.availableQuantity();
        this.category = request.category();
    }
}
