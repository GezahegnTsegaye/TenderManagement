package com.egov.tendering.tender.dal.dto;


import jakarta.validation.constraints.NotBlank;
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
public class PricingItemRequest {
    @NotBlank(message = "Item code is required")
    @Size(max = 20, message = "Item code cannot exceed 20 characters")
    private String code;

    @NotBlank(message = "Item name is required")
    @Size(max = 100, message = "Item name cannot exceed 100 characters")
    private String name;

    private String description;

    private BigDecimal defaultPrice;

    private String unit;
}
