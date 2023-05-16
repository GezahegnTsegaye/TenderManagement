package com.tms.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDetailDTO {
  private Long contactId;
  private String email;
  private String phoneNumber;
  private String mobileNumber;
  private String faxNumber;
  private String postalAddress;
  private String city;
  private String state;
  private String street;
  private int streetNumber;
  private String zipCode;
  private String country;
}
