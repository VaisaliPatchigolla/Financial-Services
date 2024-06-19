package com.finance.ReportingServiceMng.controller;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finance.ReportingServiceMng.model.TransactionDTO;
import com.finance.ReportingServiceMng.service.ReportService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/Reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/daily")
    public ResponseEntity<List<TransactionDTO>> getDailyReport(@RequestParam("accountNumber") String accountNumber) {
        List<TransactionDTO> dailyReports = reportService.getDailyReports(accountNumber);
        return new ResponseEntity<>(dailyReports, HttpStatus.OK);
    }

    @GetMapping("/weekly")
    public ResponseEntity<List<TransactionDTO>> getWeeklyReport(@RequestParam("accountNumber") String accountNumber) {
        List<TransactionDTO> weeklyReports = reportService.getWeeklyReports(accountNumber);
        return new ResponseEntity<>(weeklyReports, HttpStatus.OK);
    }

    @GetMapping("/monthly")
    public ResponseEntity<List<TransactionDTO>> getMonthlyReport(@RequestParam("accountNumber") String accountNumber) {
        List<TransactionDTO> monthlyReports = reportService.getMonthlyReports(accountNumber);
        return new ResponseEntity<>(monthlyReports, HttpStatus.OK);
    }

    @GetMapping("/yearly")
    public ResponseEntity<List<TransactionDTO>> getYearlyReport(@RequestParam("accountNumber") String accountNumber) {
        List<TransactionDTO> yearlyReports = reportService.getYearlyReports(accountNumber);
        return new ResponseEntity<>(yearlyReports, HttpStatus.OK);
    }

//    @GetMapping("/custom")
//    public ResponseEntity<List<TransactionDTO>> getCustomRangeReport(
//            @RequestParam("accountNumber") String accountNumber,
//            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
//            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
//        List<TransactionDTO> customRangeReports = reportService.getCustomRangeReports(accountNumber, startDate, endDate);
//        return new ResponseEntity<>(customRangeReports, HttpStatus.OK);
//    }
    
}
