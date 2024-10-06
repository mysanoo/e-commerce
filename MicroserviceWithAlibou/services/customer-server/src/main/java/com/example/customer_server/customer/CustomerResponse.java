package com.example.customer_server.customer;

import lombok.Data;

@Data
public class CustomerResponse{

    String firstname;
    String lastname;
    String email;
    Address address;


    CustomerResponse(Customer customer){
        this.firstname = customer.getFirstname();
        this.lastname = customer.getLastname();
        this.email = customer.getEmail();
        this.address = customer.getAddress();
    }
}
