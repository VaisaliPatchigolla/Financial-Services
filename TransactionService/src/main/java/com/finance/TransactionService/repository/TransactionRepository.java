package com.finance.TransactionService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.finance.TransactionService.model.Transaction;
import java.util.List;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByAccountNumber(String accountNumber);
}
