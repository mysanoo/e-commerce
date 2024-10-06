package com.example.notification_server.notification;

import com.example.notification_server.email.EmailService;
import com.example.notification_server.kafka.order.OrderConfirmation;
import com.example.notification_server.kafka.payment.PaymentConfirmation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository repository;
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation confirmation){
        log.info(format("Consuming the message from payment-topic Topic:: %s", confirmation));

        repository.save(Notification.builder()
                        .notificationType(NotificationType.PAYMENT_CONFIRMATION)
                        .notificationDate(LocalDateTime.now())
                        .paymentConfirmation(confirmation)
                .build());

    // todo send email
        var customerName = confirmation.costumerName() + " " +
                confirmation.costumerLastname();

        emailService.sendPaymentSuccessEmail(
                confirmation.email(),
                customerName,
                confirmation.amount(),
                confirmation.orderReference()
        );
    }


    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotification(OrderConfirmation confirmation){
        log.info(format("Consuming the message from order-topic Topic:: %s", confirmation));

        repository.save(Notification.builder()
                .notificationType(NotificationType.ORDER_CONFIRMATION)
                .notificationDate(LocalDateTime.now())
                .orderConfirmation(confirmation)
                .build());

        // todo send email

        var customerName = confirmation.customer().firstname() + " " +
                confirmation.customer().lastname();

        emailService.sendOrderConfirmationEmail(
                confirmation.customer().email(),
                customerName,
                confirmation.totalAmount(),
                confirmation.orderReference(),
                confirmation.products()
        );
    }

}
