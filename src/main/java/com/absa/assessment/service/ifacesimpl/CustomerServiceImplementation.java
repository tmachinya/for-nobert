package com.absa.assessment.service.ifacesimpl;

import com.absa.assessment.constants.AppConstants;
import com.absa.assessment.data.payload.CustomerResponse;
import com.absa.assessment.enums.TransactionType;
import com.absa.assessment.model.Customer;
import com.absa.assessment.model.Transaction;
import com.absa.assessment.repositories.CustomerRepository;
import com.absa.assessment.service.ifaces.CustomerService;
import com.absa.assessment.service.ifaces.TransactionService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomerServiceImplementation implements CustomerService {
    private  final CustomerRepository customerRepository;
    private  final TransactionService transactionService;
    public CustomerServiceImplementation(CustomerRepository customerRepository, TransactionService transactionService) {
        this.customerRepository = customerRepository;
        this.transactionService = transactionService;
    }

    @Override
    public CustomerResponse createCustomer(Customer customer) {
//        builder pattern
        Transaction transaction = Transaction.builder()
                .sourceAccountNumber("test 2025")
                .type(TransactionType.CREATION_BONUS)
                .amount(AppConstants.INITIAL_BONUS)
                .build();
        transactionService.createTransaction(transaction);
        customerRepository.save(customer);
//        TODO: respond with a meaning result;
        CustomerResponse customerResponse =  CustomerResponse
                .builder()
                .timestamp(LocalDateTime.now())
                .message("Customer created successfully")
                .result("Success")
                .build();
        return customerResponse;
    }
}
