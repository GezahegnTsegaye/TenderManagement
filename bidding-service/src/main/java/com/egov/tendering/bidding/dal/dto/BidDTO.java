package com.egov.tendering.bidding.dal.dto;

import com.egov.tendering.bidding.dal.model.BidStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidDTO {
    private Long id;
    private Long tenderId;
    private Long tendererId;
    private String tendererName;
    private BidStatus status;
    private BigDecimal totalPrice;
    private LocalDateTime submissionTime;
    private LocalDateTime createdAt;
    private List<BidItemDTO> items;
    private List<BidDocumentDTO> documents;
}