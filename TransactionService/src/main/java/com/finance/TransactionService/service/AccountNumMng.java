package com.finance.TransactionService.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.finance.TransactionService.model.AccountDTO;

@FeignClient(name = "AccountManagement", url = "http://localhost:8080") 
public interface AccountNumMng {

    @GetMapping("api/accounts/number/{accountNumber}")
    public AccountDTO getAccountByAccountNumber(@PathVariable("accountNumber") String accountNumber);

}