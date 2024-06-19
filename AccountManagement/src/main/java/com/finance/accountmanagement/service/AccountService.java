package com.finance.accountmanagement.service;

import com.finance.accountmanagement.model.Account;
import com.finance.accountmanagement.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }

    public Optional<Account> getAccountByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }
    
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(String accountNumber, Account updatedAccount) {
        Optional<Account> optionalAccount = accountRepository.findByAccountNumber(accountNumber);
        if (optionalAccount.isPresent()) {
            Account existingAccount = optionalAccount.get();
            // Update the existing account with the new values
            existingAccount.setBalance(updatedAccount.getBalance());
            existingAccount.setPin(updatedAccount.getPin());
            // Save the updated account
            return accountRepository.save(existingAccount);
        } else {
            throw new NoSuchElementException("Account not found with account number: " + accountNumber);
        }
    }

    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }
    
    public boolean changePin(Long accountId, String oldPin, String newPin) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            if (account.getPin().equals(oldPin)) {
                account.setPin(newPin);
                accountRepository.save(account);
                return true;
            }
        }
        return false;
    }

    public Optional<BigDecimal> getAccountBalance(Long accountId) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        return optionalAccount.map(Account::getBalance);
    }
}

