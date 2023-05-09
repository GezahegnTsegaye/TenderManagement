package com.tms.dal.repository;

import com.tms.dal.models.InsuranceType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface InsuranceTypeRepository extends JpaRepository<InsuranceType, Long> {
}
