package com.absa.assessment.service.ifaces;

import com.absa.assessment.data.payload.CustomerResponse;
import com.absa.assessment.model.Customer;

public interface CustomerService {
    CustomerResponse createCustomer(Customer customer);
}
