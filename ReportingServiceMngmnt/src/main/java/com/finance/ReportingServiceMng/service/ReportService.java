package com.finance.ReportingServiceMng.service;

import org.springframework.stereotype.Service;

import com.finance.ReportingServiceMng.model.TransactionDTO;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReportService {

    private final TransactionClient transactionClient;

    public ReportService(TransactionClient transactionClient) {
        this.transactionClient = transactionClient;
    }

    public List<TransactionDTO> getDailyReports(String accountNumber) {
        return transactionClient.getTransactionHistory(accountNumber);
    }

    public List<TransactionDTO> getWeeklyReports(String accountNumber) {
        return transactionClient.getTransactionHistory(accountNumber);
    }

    public List<TransactionDTO> getMonthlyReports(String accountNumber) {
        return transactionClient.getTransactionHistory(accountNumber);
    }

    public List<TransactionDTO> getYearlyReports(String accountNumber) {
        return transactionClient.getTransactionHistory(accountNumber);
    }

    public List<TransactionDTO> getCustomRangeReports(String accountNumber, LocalDate startDate, LocalDate endDate) {
        throw new UnsupportedOperationException("Custom range reports not supported by transaction history endpoint.");
    }
}
