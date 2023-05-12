package com.tms.dal.dto;

import com.tms.dal.models.BusinessCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class BusinessRegistrationDTO {
  private Long registrationId;
  private String businessName;
  private String businessAddress;
  private String businessContactDetails;
  private LocalDate businessRegistrationDate;
  private BusinessCategory businessCategory;
}
