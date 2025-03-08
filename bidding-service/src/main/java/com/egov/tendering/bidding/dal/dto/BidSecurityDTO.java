package com.egov.tendering.bidding.dal.dto;


import com.egov.tendering.bidding.dal.model.SecurityStatus;
import com.egov.tendering.bidding.dal.model.SecurityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidSecurityDTO {
    private Long id;
    private Long bidId;
    private SecurityType type;
    private BigDecimal amount;
    private String issuerName;
    private String referenceNumber;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private String documentPath;
    private SecurityStatus status;
    private Long verifiedBy;
    private LocalDateTime verifiedAt;
    private LocalDateTime createdAt;
}