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
public class CriteriaScoreDTO {
    private Long id;
    private Long criteriaId;
    private String criteriaName;
    private BigDecimal score;
    private String justification;
}