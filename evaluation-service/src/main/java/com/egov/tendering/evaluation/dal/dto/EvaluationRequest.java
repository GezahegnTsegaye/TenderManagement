package com.egov.tendering.evaluation.dal.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EvaluationRequest {

    @NotNull(message = "Bid ID is required")
    private Long bidId;

    @NotEmpty(message = "At least one criteria score is required")
    @Valid
    private List<CriteriaScoreRequest> criteriaScores;

    @Size(max = 2000, message = "Comments cannot exceed 2000 characters")
    private String comments;
}