package com.example.customer_server.customer;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService costumerService;

    @PostMapping
    public ResponseEntity<String> createCostumer(
            @RequestBody @Valid CustomerRequest request
    ){
        return ResponseEntity.ok(costumerService.createCostumer(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequest request
    ){
        costumerService.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll(){
        return ResponseEntity.ok(costumerService.findAll());
    }

    @GetMapping(value = "/exist/{customer-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> existsById(
            @PathVariable("customer-id") String customerId
    ){
        return ResponseEntity.ok(costumerService.existsById(customerId));
    }

    @GetMapping(value = "/{customer-id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerResponse> findById(
            @PathVariable("customer-id") String customerId
    ){
        return ResponseEntity.ok(costumerService.findById(customerId));
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void> deleteCustomer(
            @PathVariable("customer-id") String customerId
    ){
        costumerService.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }
}

