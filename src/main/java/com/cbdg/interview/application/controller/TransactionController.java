package com.cbdg.interview.application.controller;

import com.cbdg.interview.application.model.Transaction;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@Tag(name = "Transaction Management", description = "APIs for managing bank transactions")
public class TransactionController {

    @Operation(
            summary = "Create transaction",
            description = "Creates a new transaction for an account"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201", // Updated from 200 to 201
                    description = "Transaction created successfully",
                    content = @Content(schema = @Schema(implementation = Transaction.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid transaction data"
            )
    })
    @PostMapping
    public ResponseEntity<Transaction> createTransaction(
            @RequestBody
            @Valid
            @Parameter(description = "Transaction details", required = true)
            Transaction transaction
    ) {
        transaction.setId(1L);
        transaction.setDate(new Date());
        return ResponseEntity.status(201).body(transaction); // Status code 201 for resource creation
    }

    @Operation(
            summary = "Get monthly statements",
            description = "Retrieves all transactions for a specific month"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved transactions",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = Transaction.class)))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid month format"
            )
    })
    @GetMapping("/statements/{month}")
    public ResponseEntity<List<Transaction>> getMonthlyStatement(
            @Parameter(description = "Month in YYYY-MM format", example = "2024-03")
            @PathVariable String month
    ) {
        List<Transaction> transactions = List.of(
                new Transaction(1L, "credit", 200.0, "Salary", new Date()),
                new Transaction(2L, "debit", 50.0, "Groceries", new Date())
        );
        return ResponseEntity.ok(transactions);
    }
}