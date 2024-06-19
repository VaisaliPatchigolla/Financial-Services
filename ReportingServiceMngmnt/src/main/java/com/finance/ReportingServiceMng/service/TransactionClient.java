package com.finance.ReportingServiceMng.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.finance.ReportingServiceMng.model.TransactionDTO;

@FeignClient(name = "TransactionMngmnt", url = "http://localhost:8082") 
public interface TransactionClient {
	
    @GetMapping("/api/transactions/history")
    List<TransactionDTO> getTransactionHistory(@RequestParam("accountNumber") String accountNumber);
}

