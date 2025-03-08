package com.egov.tendering.tender.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenderItemDTO {
  private Long id;
  private Long criteriaId;
  private String name;
  private String description;
  private Integer quantity;
  private String unit;
  private BigDecimal estimatedPrice;
}
