package com.finance.ComplianceService.service;

import java.util.List;

import com.finance.ComplianceService.model.ComplianceRule;

public interface ComplianceService {
 
 List<ComplianceRule> getAllComplianceRules();
 
 ComplianceRule getComplianceRuleById(Long id);
 
 ComplianceRule createComplianceRule(ComplianceRule complianceRule);
 
 ComplianceRule updateComplianceRule(Long id, ComplianceRule complianceRule);
 
 void deleteComplianceRule(Long id);
}

