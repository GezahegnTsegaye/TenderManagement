package com.egov.tendering.bidding.dal.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidItemRequest {

    @NotNull(message = "Criteria ID is required")
    private Long criteriaId;

    @NotNull(message = "Value is required")
    @DecimalMin(value = "0.0", message = "Value must be positive")
    private BigDecimal value;

    private String description;
}