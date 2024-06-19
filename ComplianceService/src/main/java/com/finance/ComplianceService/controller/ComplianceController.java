package com.finance.ComplianceService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.finance.ComplianceService.model.ComplianceRule;
import com.finance.ComplianceService.service.ComplianceService;

import java.util.List;

@RestController
@RequestMapping("/api/compliance")
public class ComplianceController {

    private final ComplianceService complianceService;

    @Autowired
    public ComplianceController(ComplianceService complianceService) {
        this.complianceService = complianceService;
    }

    @GetMapping("/rules")
    public List<ComplianceRule> getAllComplianceRules() {
        return complianceService.getAllComplianceRules();
    }

    @GetMapping("/rules/{id}")
    public ComplianceRule getComplianceRuleById(@PathVariable Long id) {
        return complianceService.getComplianceRuleById(id);
    }

    @PostMapping("/rules")
    public ComplianceRule createComplianceRule(@RequestBody ComplianceRule complianceRule) {
        return complianceService.createComplianceRule(complianceRule);
    }

    @PutMapping("/rules/{id}")
    public ComplianceRule updateComplianceRule(@PathVariable Long id, @RequestBody ComplianceRule complianceRule) {
        return complianceService.updateComplianceRule(id, complianceRule);
    }

    @DeleteMapping("/rules/{id}")
    public void deleteComplianceRule(@PathVariable Long id) {
        complianceService.deleteComplianceRule(id);
    }
}
