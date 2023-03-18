package com.absa.assessment.service.ifacesimpl;

import com.absa.assessment.model.Transaction;
import com.absa.assessment.repositories.TransactionRepository;
import com.absa.assessment.service.ifaces.TransactionService;
import org.springframework.stereotype.Component;

@Component
public class TransactionServiceImplementation implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImplementation(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
}
