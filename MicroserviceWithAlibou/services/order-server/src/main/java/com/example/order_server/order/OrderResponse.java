package com.example.order_server.order;

import com.example.order_server.orderline.OrderLine;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderResponse {

    private Integer id;
    private String reference;
    private BigDecimal totalAmount;
    private PaymentMethod paymentMethod;
    private String customerId;
    private List<OrderLine> orderLines;
    private LocalDateTime createAt;
    private LocalDateTime lastModifiedDate;

    public OrderResponse(Order order){
        this.id = order.getId();
        this.reference = order.getReference();
        this.totalAmount = order.getTotalAmount();
        this.paymentMethod = order.getPaymentMethod();
        this.customerId = order.getCustomerId();
        this.orderLines = order.getOrderLines();
        this.createAt = order.getCreateAt();
        this.lastModifiedDate = order.getLastModifiedDate();
    }
}
