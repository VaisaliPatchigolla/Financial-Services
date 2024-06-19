package com.finance.ComplianceService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finance.ComplianceService.model.ComplianceRule;
import com.finance.ComplianceService.repository.ComplianceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ComplianceServiceImpl implements ComplianceService {

 private final ComplianceRepository complianceRepository;

 @Autowired
 public ComplianceServiceImpl(ComplianceRepository complianceRepository) {
     this.complianceRepository = complianceRepository;
 }

 @Override
 public List<ComplianceRule> getAllComplianceRules() {
     return complianceRepository.findAll();
 }

 @Override
 public ComplianceRule getComplianceRuleById(Long id) {
     Optional<ComplianceRule> optionalComplianceRule = complianceRepository.findById(id);
     return optionalComplianceRule.orElse(null);
 }

 @Override
 public ComplianceRule createComplianceRule(ComplianceRule complianceRule) {
     return complianceRepository.save(complianceRule);
 }

 @Override
 public ComplianceRule updateComplianceRule(Long id, ComplianceRule complianceRule) {
     if (complianceRepository.existsById(id)) {
         complianceRule.setId(id);
         return complianceRepository.save(complianceRule);
     }
     return null;
 }

 @Override
 public void deleteComplianceRule(Long id) {
     complianceRepository.deleteById(id);
 }
}
