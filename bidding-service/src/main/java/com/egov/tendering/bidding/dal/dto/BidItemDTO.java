package com.egov.tendering.bidding.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BidItemDTO {
  private Long id;
  private Long criteriaId;
  private String criteriaName;
  private BigDecimal value;
  private String description;
}