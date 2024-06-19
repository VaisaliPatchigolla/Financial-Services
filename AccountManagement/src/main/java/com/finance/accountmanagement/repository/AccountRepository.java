package com.finance.accountmanagement.repository;

import com.finance.accountmanagement.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

	List<Account> findAll();

    Optional<Account> findById(Long accountId);

    @Override
    Account save(Account account);

    @Override
    void deleteById(Long accountId);
    
    Optional<Account> findByAccountNumber(String accountNumber);
}

