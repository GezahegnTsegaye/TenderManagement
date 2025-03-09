package com.egov.tendering.evaluation.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenderRankingDTO {
    private Long id;
    private Long tenderId;
    private Long bidId;
    private String bidderName;
    private BigDecimal finalScore;
    private Integer rank;
    private Boolean isWinner;
}