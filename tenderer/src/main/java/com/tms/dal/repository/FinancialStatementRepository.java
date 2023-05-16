package com.tms.dal.repository;

import com.tms.dal.models.FinancialStatement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialStatementRepository extends JpaRepository<FinancialStatement, Long> {
}
