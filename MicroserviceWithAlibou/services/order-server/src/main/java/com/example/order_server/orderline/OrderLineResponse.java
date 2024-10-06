package com.example.order_server.orderline;

import com.example.order_server.order.Order;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderLineResponse {

    private Integer id;

    private Order order;

    private Integer productId;

    private Integer quantity;

    public OrderLineResponse(OrderLine orderLine){
        this.id = orderLine.getId();
        this.order = orderLine.getOrder();
        this.productId = orderLine.getProductId();
        this.quantity = orderLine.getQuantity();
    }
}
