package com.egov.tendering.evaluation.event;

import com.egov.tendering.evaluation.dal.model.EvaluationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Event payload for evaluation update
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationUpdatedEvent {
    private Long evaluationId;
    private Long tenderId;
    private Long bidId;
    private Long evaluatorId;
    private EvaluationStatus status;
    private BigDecimal overallScore;
    private LocalDateTime timestamp;
}