package com.example.payment_server.payment;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.IdentityHashMap;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private Integer orderId;
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createAt;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;

//    @PrePersist
//    public void prePersist() {
//        createAt = LocalDateTime.now();
//        lastModifiedDate = LocalDateTime.now(); // Автоматическое заполнение
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        lastModifiedDate = LocalDateTime.now(); // Обновление при каждом изменении
//    }

    public Payment(PaymentRequest request){
        this.id = request.id();
        this.amount = request.amount();
        this.paymentMethod = request.paymentMethod();
        this.orderId = request.orderId();
    }
}
