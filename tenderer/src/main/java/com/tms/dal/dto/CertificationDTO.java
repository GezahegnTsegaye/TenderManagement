package com.tms.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CertificationDTO {
  private Long certificationId;
  private String certificationName;
  private String certificationDescription;
  private String certificationAuthority;
  private Long tendererId;

  // Getters and setters
}
