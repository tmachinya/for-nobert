package com.absa.assessment.model;

import com.absa.assessment.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private double balance;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    private String accountType;

    public Account(String accountNumber, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountType = accountType;
    }

    public void addTransaction(Transaction transaction) {
        if (transaction.getAmount() <= 0) {
            throw new IllegalArgumentException("Transaction amount must be greater than 0");
        }
        if (transaction.getType() == TransactionType.WITHDRAWAL && transaction.getAmount() > this.getBalance()) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        this.balance += transaction.getAmount();
        this.transactions.add(transaction);
    }

}
