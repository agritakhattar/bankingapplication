package com.cbdg.interview.application.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Schema(
    description = "Transaction details",
    requiredProperties = {"transactionType", "amount", "description"}
)
@Getter
@Setter
public class Transaction {
    @Schema(description = "Unique transaction identifier")
    private Long id;

    @Schema(description = "Type of transaction (credit/debit)", example = "credit")
    private String transactionType;

    @Schema(description = "Transaction amount", example = "100.00")
    private Double amount;

    @Schema(description = "Transaction description", example = "Grocery shopping")
    private String description;

    @Schema(description = "Transaction date")
    private Date date;

    public Transaction(Long id, String transactionType, double amount, String description, Date date) {
        this.id = id;
        this.transactionType = transactionType;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }
}