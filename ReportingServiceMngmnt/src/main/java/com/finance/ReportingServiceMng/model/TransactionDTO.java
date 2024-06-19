package com.finance.ReportingServiceMng.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {
    private Long transactionId;
    private BigDecimal amount;
    private String accountNumber;
    private LocalDateTime timestamp;

    public TransactionDTO() {
        // Default constructor
    }
    
    public TransactionDTO(Long transactionId, BigDecimal amount, String accountNumber, LocalDateTime timestamp) {
		super();
		this.transactionId = transactionId;
		this.amount = amount;
		this.accountNumber = accountNumber;
		this.timestamp = timestamp;
	}

	public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

    
}
