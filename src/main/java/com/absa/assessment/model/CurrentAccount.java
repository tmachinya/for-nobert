package com.absa.assessment.model;

import com.absa.assessment.enums.TransactionType;
import jakarta.persistence.*;

@Entity
public class CurrentAccount extends Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Customer customer;

}
