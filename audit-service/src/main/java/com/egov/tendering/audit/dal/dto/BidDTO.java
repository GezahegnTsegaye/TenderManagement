package com.egov.tendering.audit.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter@AllArgsConstructor@NoArgsConstructor
public class BidDTO {

  private Long bidId;
  private Double price;
}
