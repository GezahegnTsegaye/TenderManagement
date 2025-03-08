package com.egov.tendering.bidding.service;


import com.egov.tendering.bidding.dal.dto.ComplianceCheckResult;
import com.egov.tendering.bidding.dal.dto.ComplianceRequirementDTO;

import java.util.List;

public interface ComplianceService {

    List<ComplianceRequirementDTO> getComplianceRequirements(Long tenderId);

    ComplianceRequirementDTO addComplianceRequirement(Long tenderId, ComplianceRequirementDTO requirement, Long createdBy);

    void deleteComplianceRequirement(Long requirementId);

    ComplianceCheckResult checkBidCompliance(Long bidId);

    void verifyComplianceItem(Long complianceItemId, Boolean compliant, String comment, Long verifiedBy);
}