package com.cbdg.interview.application.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "Bank account details")
@Data
public class Account {
    @Schema(description = "Unique account identifier")
    private Long id;

    @Schema(description = "Bank account number", example = "123456789")
    private String bankAccountNumber;

    @Schema(description = "Type of account", example = "Savings")
    private String accountType;
    @Schema(description = "Current balance", example = "1000.00")
    private Double balance;

    public Account(Long accountId, String number, String accountType, double balance) {
        this.id = accountId;
        this.bankAccountNumber = number;
        this.accountType = accountType;
        this.balance = balance;

    }
}
