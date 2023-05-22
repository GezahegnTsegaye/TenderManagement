package com.tms.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TendereeDTO {
  private Long id;
  private String name;
  private ContactDetailDTO contactDetail;
  private String address;
  private List<TenderDTO> tenderList;
}
