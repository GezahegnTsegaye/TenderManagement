package com.egov.tendering.evaluation.dal.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * DTO for allocation request parameters
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AllocationRequest {

    /**
     * Cut-off score for competitive allocation.
     * Bids with scores above this threshold are considered for allocation.
     */
    @NotNull(message = "Cutoff score is required")
    @DecimalMin(value = "0.0", message = "Cutoff score must be at least 0")
    private BigDecimal cutoffScore;

    /**
     * Whether to use average allocation (true) or proportional allocation (false).
     * In average allocation, items are distributed evenly among winners.
     * In proportional allocation, items are distributed based on score ratios.
     */
    private boolean averageAllocation;
}