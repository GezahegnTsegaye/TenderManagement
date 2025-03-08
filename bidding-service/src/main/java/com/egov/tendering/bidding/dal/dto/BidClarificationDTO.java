package com.egov.tendering.bidding.dal.dto;

import com.egov.tendering.bidding.dal.model.ClarificationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidClarificationDTO {
    private Long id;
    private Long bidId;
    private String question;
    private String response;
    private Long requestedBy;
    private LocalDateTime requestedAt;
    private LocalDateTime respondedAt;
    private LocalDateTime deadline;
    private ClarificationStatus status;
}