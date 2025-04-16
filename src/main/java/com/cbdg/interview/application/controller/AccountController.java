package com.cbdg.interview.application.controller;

import com.cbdg.interview.application.model.Account;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@Tag(name = "Account Management", description = "APIs for managing bank accounts")
public class AccountController {

    @Operation(
            summary = "Get all accounts",
            description = "Retrieves a list of all bank accounts in the system"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Successfully retrieved accounts",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Account.class)))
    )
    @GetMapping
    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> accounts = List.of(
                new Account(1L, "123456789", "Savings", 1000.0),
                new Account(2L, "987654321", "Checking", 500.0)
        );
        return ResponseEntity.ok(accounts);
    }

    @Operation(
            summary = "Get account by ID",
            description = "Retrieves details of a specific bank account using its ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Account found",
                    content = @Content(schema = @Schema(implementation = Account.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Account not found"
            )
    })
    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountDetails(
            @Parameter(description = "ID of the account to retrieve")
            @PathVariable Long accountId
    ) {
        Account account = new Account(accountId, "123456789", "Savings", 1000.0);
        return ResponseEntity.ok(account);
    }

    @Operation(
            summary = "Create account",
            description = "Creates a new bank account"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Account created successfully",
                    content = @Content(schema = @Schema(implementation = Account.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid account data"
            )
    })
    @PostMapping
    public ResponseEntity<Account> createAccount(
            @Parameter(description = "Account details", required = true)
            @RequestBody @Valid Account account
    ) {
        // Generate a new ID for the account
        account.setId(generateNextId());

        // In a real application, you would save the account to a database here
        // For now, we'll just return the created account

        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    // Helper method to generate IDs (replace with proper ID generation in production)
    private Long generateNextId() {
        return System.currentTimeMillis();
    }
}