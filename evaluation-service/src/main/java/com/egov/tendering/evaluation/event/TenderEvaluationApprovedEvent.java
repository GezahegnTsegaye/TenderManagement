package com.egov.tendering.evaluation.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Event payload for tender evaluation approval
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenderEvaluationApprovedEvent {
    private Long tenderId;
    private LocalDateTime timestamp;
}