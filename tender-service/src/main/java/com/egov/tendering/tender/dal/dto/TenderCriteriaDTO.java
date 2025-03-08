package com.egov.tendering.tender.dal.dto;


import com.egov.tendering.tender.dal.model.CriteriaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TenderCriteriaDTO {
  private Long id;
  private String name;
  private String description;
  private CriteriaType type;
  private BigDecimal weight;
  private Boolean preferHigher;
  private boolean active;
}