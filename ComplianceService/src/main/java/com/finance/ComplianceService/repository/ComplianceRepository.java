package com.finance.ComplianceService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.ComplianceService.model.ComplianceRule;

@Repository
public interface ComplianceRepository extends JpaRepository<ComplianceRule, Long> {
    void deleteById(Long id);
    ComplianceRule save(ComplianceRule complianceRule);
    boolean existsById(Long id); 
    Optional<ComplianceRule> findById(Long id);
    List<ComplianceRule> findAll(); 
}
