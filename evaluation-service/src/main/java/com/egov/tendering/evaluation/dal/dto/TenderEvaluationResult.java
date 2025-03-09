package com.egov.tendering.evaluation.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenderEvaluationResult {
    private Long tenderId;
    private List<TenderRankingDTO> rankings;
    private List<AllocationResultDTO> allocations;
    private boolean completed;
}