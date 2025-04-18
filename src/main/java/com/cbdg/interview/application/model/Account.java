package com.cbdg.interview.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Bank account details")
@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String bankAccountNumber;

    private String accountType;

    private Double balance;

    public Account(Long accountId, String number, String accountType, double balance) {
        this.id = accountId;
        this.bankAccountNumber = number;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Account() {
        // Default constructor for JPA
    }
}
