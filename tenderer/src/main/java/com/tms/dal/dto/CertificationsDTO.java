package com.tms.dal.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@AllArgsConstructor@NoArgsConstructor@Getter
public class CertificationsDTO {
  private Long certificationId;
  private String certificationName;
  private String certificationDescription;
  private String certificationAuthority;
  private TenderDTO tenderDTO;
}
