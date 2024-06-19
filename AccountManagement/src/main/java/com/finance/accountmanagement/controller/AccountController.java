package com.finance.accountmanagement.controller;


import com.finance.accountmanagement.model.Account;
import com.finance.accountmanagement.model.User;
import com.finance.accountmanagement.service.AccountService;
import com.finance.accountmanagement.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	private final AccountService accountService;
    private final UserService userService;

    public AccountController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    
    @GetMapping("/id/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
        Optional<Account> account = accountService.getAccountById(accountId);
        return account.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/number/{accountNumber}")
    public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable String accountNumber) {
        Optional<Account> account = accountService.getAccountByAccountNumber(accountNumber);
        return account.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping("/{userId}")
    public ResponseEntity<Account> createAccountForUser(@PathVariable Long userId, @RequestBody Account account) {
        Optional<User> optionalUser = userService.getUserById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            account.setUser(user);
            Account createdAccount = accountService.createAccount(account);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/{accountNumber}/update-user")
    public ResponseEntity<Account> updateAccountWithUser(@PathVariable String accountNumber, @RequestBody Account account) {
        Optional<Account> accountOptional = accountService.getAccountByAccountNumber(accountNumber);
        
        if (accountOptional.isPresent()) {
            account.setUser(accountOptional.get().getUser());
            Account updatedAccount = accountService.updateAccount(accountNumber, account);
            return ResponseEntity.ok(updatedAccount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{accountId}/change-pin")
    public ResponseEntity<String> changePin(@PathVariable Long accountId, @RequestParam("oldPin") String oldPin, @RequestParam("newPin") String newPin) {
        boolean pinChanged = accountService.changePin(accountId, oldPin, newPin);
        if (pinChanged) {
            return ResponseEntity.ok("PIN changed successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to change PIN. Please check the old PIN.");
        }
    }

    @GetMapping("/{accountId}/balance")
    public ResponseEntity<BigDecimal> getAccountBalance(@PathVariable Long accountId) {
        Optional<BigDecimal> balance = accountService.getAccountBalance(accountId);
        return balance.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
