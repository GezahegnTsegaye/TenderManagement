package com.tms.dal.repository;

import com.tms.dal.model.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentTypeRepository extends JpaRepository<Criteria, Long> {
}
