package com.finance.TransactionService.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.finance.TransactionService.enums.TransactionType;
import com.finance.TransactionService.model.AccountDTO;
import com.finance.TransactionService.model.Transaction;
import com.finance.TransactionService.repository.TransactionRepository;
import java.math.BigDecimal;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountNumMng accountNumMng;

    public TransactionService(TransactionRepository transactionRepository, AccountNumMng accountNumMng) {
        this.transactionRepository = transactionRepository;
        this.accountNumMng = accountNumMng;
    }

    @Transactional
    public String deposit(String accountNumber, BigDecimal amount) {
        updateBalance(accountNumber, amount);
        saveTransaction(accountNumber, amount, TransactionType.DEPOSIT);
        updateBalance(accountNumber);
        return "Deposit successful.";
    }

    @Transactional
    public String withdraw(String accountNumber, BigDecimal amount) {
        AccountDTO accountBefore = accountNumMng.getAccountByAccountNumber(accountNumber);
        if (accountBefore == null) {
            return "Account not found.";
        }
        if (accountBefore.getBalance().compareTo(amount) < 0) {
            return "Insufficient balance for withdrawal.";
        }

        saveTransaction(accountNumber, amount.negate(), TransactionType.WITHDRAWAL);
        
        // Update balance after withdrawal
        updateBalance(accountNumber);
        
        return "Withdrawal successful.";
    }

    @Transactional
    public String transfer(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        AccountDTO fromAccountBefore = accountNumMng.getAccountByAccountNumber(fromAccountNumber);
        AccountDTO toAccountBefore = accountNumMng.getAccountByAccountNumber(toAccountNumber);
        if (fromAccountBefore == null || toAccountBefore == null) {
            return "One or both accounts not found.";
        }
        if (fromAccountBefore.getBalance().compareTo(amount) < 0) {
            return "Insufficient balance for transfer.";
        }

        saveTransaction(fromAccountNumber, amount.negate(), TransactionType.TRANSFER);
        saveTransaction(toAccountNumber, amount, TransactionType.TRANSFER);
        
        // Update balances after transfer
        updateBalance(fromAccountNumber);
        updateBalance(toAccountNumber);
        
        return "Transfer successful.";
    }

    @Transactional
    public List<Transaction> getTransactionHistory(String accountNumber) {
        return transactionRepository.findByAccountNumber(accountNumber);
    }

    private void saveTransaction(String accountNumber, BigDecimal amount, TransactionType type) {
        Transaction transaction = new Transaction(amount, type, accountNumber);
        transactionRepository.save(transaction);
    }

    private void updateBalance(String accountNumber, BigDecimal amount) {
        AccountDTO accountBefore = accountNumMng.getAccountByAccountNumber(accountNumber);
        BigDecimal updatedBalance = accountBefore.getBalance().add(amount);
        accountBefore.setBalance(updatedBalance);
    }
    
    private void updateBalance(String accountNumber) {
        AccountDTO accountAfter = accountNumMng.getAccountByAccountNumber(accountNumber);
        BigDecimal currentBalance = BigDecimal.ZERO;
        List<Transaction> transactions = transactionRepository.findByAccountNumber(accountNumber);
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.DEPOSIT) {
                currentBalance = currentBalance.add(transaction.getAmount());
            } else if (transaction.getType() == TransactionType.WITHDRAWAL || transaction.getType() == TransactionType.TRANSFER) {
                currentBalance = currentBalance.subtract(transaction.getAmount());
            }
        }
        accountAfter.setBalance(currentBalance);
    }
}
