package com.egov.tendering.bidding.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplianceCheckResult {
    private boolean compliant;
    private List<BidComplianceItemDTO> complianceItems;

    // Helper method to identify non-compliant items
    public List<BidComplianceItemDTO> getNonCompliantItems() {
        return complianceItems.stream()
                .filter(item -> !item.getCompliant())
                .toList();
    }

    // Helper method to identify mandatory non-compliant items
    public List<BidComplianceItemDTO> getMandatoryNonCompliantItems() {
        return complianceItems.stream()
                .filter(item -> item.getMandatory() && !item.getCompliant())
                .toList();
    }
}