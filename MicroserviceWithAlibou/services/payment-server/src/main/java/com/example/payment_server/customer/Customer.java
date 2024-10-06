package com.example.payment_server.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Validated
public class Customer {
    private String id;
    @NotNull(message = "firstname is required")
    private String firstname;
    @NotNull(message = "lastname is required")
    private String lastname;
    @NotNull(message = "email is required")
    @Email(message = "email is not correctly valid")
    private String email;
}
