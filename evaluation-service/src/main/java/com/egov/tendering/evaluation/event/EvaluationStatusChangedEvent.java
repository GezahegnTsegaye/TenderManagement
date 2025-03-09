package com.egov.tendering.evaluation.event;

import com.egov.tendering.evaluation.dal.model.EvaluationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Event payload for evaluation status change
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationStatusChangedEvent {
    private Long evaluationId;
    private Long tenderId;
    private Long bidId;
    private Long evaluatorId;
    private EvaluationStatus oldStatus;
    private EvaluationStatus newStatus;
    private LocalDateTime timestamp;
}
