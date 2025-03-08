package com.egov.tendering.tender.dal.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PricingItemDTO {
    private Long id;
    private String code;
    private String name;
    private String description;
    private BigDecimal defaultPrice;
    private String unit;
    private Long createdBy;
    private LocalDateTime createdAt;
}