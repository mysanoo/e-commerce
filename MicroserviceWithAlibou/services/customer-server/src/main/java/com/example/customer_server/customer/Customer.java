package com.example.customer_server.customer;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document
public class Customer {

    @Id
    private String id;

    private String firstname;
    private String lastname;
    private String email;
    private Address address;

    public Customer(CustomerRequest request){
        this.firstname = request.firstname();
        this.lastname = request.lastname();
        this.email = request.email();
        this.address = request.address();
    }
}
