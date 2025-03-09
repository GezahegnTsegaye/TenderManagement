package com.egov.tendering.audit.dal.repository;

import com.egov.tendering.audit.dal.model.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriteriaRepository extends JpaRepository<Criteria, Long> {
}
