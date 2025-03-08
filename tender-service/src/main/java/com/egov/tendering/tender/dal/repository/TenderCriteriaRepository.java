package com.egov.tendering.tender.dal.repository;

import com.egov.tendering.tender.dal.model.TenderCriteria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TenderCriteriaRepository extends JpaRepository<TenderCriteria, Long> {
    List<TenderCriteria> findByTenderId(Long tenderId);
}
