package com.egov.tendering.evaluation.event;

import com.egov.tendering.evaluation.dal.dto.AllocationResultDTO;
import com.egov.tendering.evaluation.dal.dto.TenderRankingDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Event payload for tender evaluation completion
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TenderEvaluationCompletedEvent {
    private Long tenderId;
    private String tenderTitle;
    private List<TenderRankingDTO> rankings;
    private List<AllocationResultDTO> allocations;
    private LocalDateTime timestamp;
}