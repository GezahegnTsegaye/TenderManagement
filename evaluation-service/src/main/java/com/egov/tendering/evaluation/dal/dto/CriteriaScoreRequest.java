package com.egov.tendering.evaluation.dal.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriteriaScoreRequest {

    @NotNull(message = "Criteria ID is required")
    private Long criteriaId;

    @NotNull(message = "Score is required")
    @DecimalMin(value = "0.0", message = "Score must be at least 0")
    @DecimalMax(value = "10.0", message = "Score cannot exceed 10")
    private BigDecimal score;

    @Size(max = 1000, message = "Justification cannot exceed 1000 characters")
    private String justification;
}