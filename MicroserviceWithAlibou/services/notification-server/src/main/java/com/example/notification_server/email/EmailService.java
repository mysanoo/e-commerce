package com.example.notification_server.email;

import com.example.notification_server.kafka.order.Product;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;


import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendPaymentSuccessEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            String orderReference
    ){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper =
                    new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED, StandardCharsets.UTF_8.name());
            messageHelper.setFrom("contact@aliboucoding.com");
            final String templateName = EmailTemplates.PAYMENT_CONFIRMATION.getTemplate();

            Map<String, Object> variables = new HashMap<>();
            variables.put("customerName", customerName);
            variables.put("amount", amount);
            variables.put("orderReference", orderReference);


            Context context = new Context();
            context.setVariables(variables);
            messageHelper.setSubject(EmailTemplates.PAYMENT_CONFIRMATION.getSubject());


            String htmlTemplate = templateEngine.process(templateName, context);
             messageHelper.setText(htmlTemplate, true);

             messageHelper.setTo(destinationEmail);
             mailSender.send(mimeMessage);
             log.info("INFO: the message successfully send to {} with template {} ", destinationEmail, htmlTemplate);

        } catch (MessagingException e) {
            log.info(String.format("WARNING: Cannot send message to {}", destinationEmail));
            throw new RuntimeException(e);
        }
    }

    @Async
    public void sendOrderConfirmationEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            String orderReference,
            List<Product> products
    ){
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper =
                    new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_RELATED, StandardCharsets.UTF_8.name());
            messageHelper.setFrom("contact@aliboucoding.com");
            final String templateName = EmailTemplates.ORDER_CONFIRMATION.getTemplate();

            Map<String, Object> variables = new HashMap<>();
            variables.put("customerName", customerName);
            variables.put("totalAmount", amount);
            variables.put("products", products);
            variables.put("orderReference", orderReference);


            Context context = new Context();
            context.setVariables(variables);
            messageHelper.setSubject(EmailTemplates.ORDER_CONFIRMATION.getSubject());


            String htmlTemplate = templateEngine.process(templateName, context);
            messageHelper.setText(htmlTemplate, true);

            messageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);
            log.info("INFO: the message successfully send to {} with template {} ", destinationEmail, htmlTemplate);

        } catch (MessagingException e) {
            log.info(String.format("WARNING: Cannot send message to {}", destinationEmail));
            throw new RuntimeException(e);
        }
    }

}
