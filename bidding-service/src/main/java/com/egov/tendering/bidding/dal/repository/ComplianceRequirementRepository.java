package com.egov.tendering.bidding.dal.repository;

import com.egov.tendering.bidding.dal.model.ComplianceRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplianceRequirementRepository extends JpaRepository<ComplianceRequirement, Long> {

    List<ComplianceRequirement> findByTenderId(Long tenderId);

    List<ComplianceRequirement> findByTenderIdAndMandatory(Long tenderId, Boolean mandatory);
}