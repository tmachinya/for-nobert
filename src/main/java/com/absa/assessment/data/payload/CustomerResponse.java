package com.absa.assessment.data.payload;

import com.absa.assessment.model.Customer;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CustomerResponse {
    private String result;
    private String accountNumber;
    private String message;
    private LocalDateTime timestamp;
}
