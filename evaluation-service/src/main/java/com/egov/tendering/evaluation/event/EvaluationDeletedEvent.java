package com.egov.tendering.evaluation.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Event payload for evaluation deletion
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationDeletedEvent {
    private Long evaluationId;
    private Long tenderId;
    private Long bidId;
    private Long evaluatorId;
    private LocalDateTime timestamp;
}