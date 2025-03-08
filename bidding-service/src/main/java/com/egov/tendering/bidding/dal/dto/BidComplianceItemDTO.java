package com.egov.tendering.bidding.dal.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidComplianceItemDTO {
    private Long id;
    private Long bidId;
    private Long requirementId;
    private String requirement;
    private Boolean mandatory;
    private Boolean compliant;
    private String comment;
    private Long verifiedBy;
    private LocalDateTime verifiedAt;
}