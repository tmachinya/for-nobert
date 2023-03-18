package com.absa.assessment.controller;

import com.absa.assessment.data.payload.CustomerResponse;
import com.absa.assessment.model.Customer;
import com.absa.assessment.service.ifaces.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class AccountController {
    private final CustomerService customerService;
    public AccountController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path="/customers", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CustomerResponse> registerDrone(@RequestBody Customer customer) {
        CustomerResponse customerResponse = customerService.createCustomer(customer);
        return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.CREATED);
    }


}
