package com.egov.tendering.evaluation.dal.dto;

import com.egov.tendering.evaluation.dal.model.EvaluationStatus;
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
public class EvaluationDTO {
    private Long id;
    private Long tenderId;
    private Long bidId;
    private String bidderName;
    private Long evaluatorId;
    private EvaluationStatus status;
    private BigDecimal overallScore;
    private String comments;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<CriteriaScoreDTO> criteriaScores;
}