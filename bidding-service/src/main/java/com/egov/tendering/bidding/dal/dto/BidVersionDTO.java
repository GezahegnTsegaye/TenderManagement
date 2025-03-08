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
public class BidVersionDTO {
    private Long id;
    private Long bidId;
    private Integer versionNumber;
    private String changeSummary;
    private Long createdBy;
    private LocalDateTime createdAt;
    private BidDTO versionData;
}