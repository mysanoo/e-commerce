package com.example.order_server.orderline;

import com.example.order_server.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class OrderLine {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private Integer productId;

    private Integer quantity;

    public OrderLine(OrderLineRequest request){
        this.id = request.id();
        this.quantity = request.quantity();
        this.productId = request.productId();
        this.order = Order.builder()
                .id(request.orderId())
                .build();
    }

}
