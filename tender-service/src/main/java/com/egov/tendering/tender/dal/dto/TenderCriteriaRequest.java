package com.egov.tendering.tender.dal.dto;


import com.egov.tendering.tender.dal.model.CriteriaType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenderCriteriaRequest {
    @NotBlank(message = "Criterion name is required")
    @Size(max = 100, message = "Criterion name cannot exceed 100 characters")
    private String name;

    private String description;

    @NotNull(message = "Criterion type is required")
    private CriteriaType type;

    @NotNull(message = "Weight is required")
    @DecimalMin(value = "0.0", message = "Weight must be positive")
    @DecimalMax(value = "100.0", message = "Weight cannot exceed 100")
    private BigDecimal weight;

    private Boolean preferHigher;
}