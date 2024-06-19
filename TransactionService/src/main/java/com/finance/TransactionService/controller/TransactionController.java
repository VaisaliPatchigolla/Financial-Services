package com.finance.TransactionService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.finance.TransactionService.model.Transaction;
import com.finance.TransactionService.service.TransactionService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestParam String accountNumber, @RequestParam BigDecimal amount) {
        String result = transactionService.deposit(accountNumber, amount);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<String> withdraw(@RequestParam String accountNumber, @RequestParam BigDecimal amount) {
        String result = transactionService.withdraw(accountNumber, amount);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestParam String fromAccountNumber, @RequestParam String toAccountNumber,
                                           @RequestParam BigDecimal amount) {
        String result = transactionService.transfer(fromAccountNumber, toAccountNumber, amount);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/history")
    public ResponseEntity<List<Transaction>> getTransactionHistory(@RequestParam String accountNumber) {
        List<Transaction> history = transactionService.getTransactionHistory(accountNumber);
        return ResponseEntity.ok(history);
    }
}

