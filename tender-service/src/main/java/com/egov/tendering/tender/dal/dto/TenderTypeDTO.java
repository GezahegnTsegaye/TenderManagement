package com.egov.tendering.tender.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class TenderTypeDTO {

  private Long tenderTypeId;
  private String description;
  private Set<TenderDTO> tenderDTOS;

}
