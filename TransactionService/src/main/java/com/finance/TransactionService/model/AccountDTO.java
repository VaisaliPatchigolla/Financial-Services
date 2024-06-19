package com.finance.TransactionService.model;

import java.math.BigDecimal;

public class AccountDTO {

    private Long accountId;
    private String accountNumber;
    private BigDecimal balance;
    private String pin;
    private Long userId;

    public AccountDTO() {
    }

    public AccountDTO(Long accountId, String accountNumber, BigDecimal balance, String pin, Long userId) {
        this.accountId = accountId;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.pin = pin;
        this.userId = userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public String getAccountDetails() {
        return "Account Number: " + this.accountNumber + "\n" +
               "Balance: " + this.balance + "\n" +
               "User ID: " + this.userId;
    }

    public void changePin(String newPin) {
        this.pin = newPin;
    }
}

