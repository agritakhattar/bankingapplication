package com.cbdg.interview.application.model;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date; // Add this import

@Data
@Entity
@Schema(description = "Details of a bank transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String type;
    private Double amount;
    private String description;
    private Date date;

    @ManyToOne
        private Account account;

    public Transaction(Long id, String type, Double amount, String description, Date date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public Transaction() {
        // Default constructor for JPA
    }
}