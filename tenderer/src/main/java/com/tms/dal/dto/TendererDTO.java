package com.tms.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TendererDTO {
  private Long tendererId;
  private String name;
  private String address;
  private String contactPerson;
  private String phone;
  private String email;
  private Long tendererRoleId;
  private Long tendererTypeId;
}
