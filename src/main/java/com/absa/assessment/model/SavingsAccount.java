package com.absa.assessment.model;

import com.absa.assessment.enums.TransactionType;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class SavingsAccount extends Account{

    public SavingsAccount(Long id, String accountNumber, double balance, List<Transaction> transactions, String accountType, Customer customer) {
        super(id, accountNumber, balance, transactions, accountType);
        this.customer = customer;
    }

    public SavingsAccount(Customer customer) {
        this.customer = customer;
    }

    public SavingsAccount(String accountNumber, double balance, String accountType, Customer customer) {
        super(accountNumber, balance, accountType);
        this.customer = customer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Customer customer;
    public SavingsAccount() {

    }
}
