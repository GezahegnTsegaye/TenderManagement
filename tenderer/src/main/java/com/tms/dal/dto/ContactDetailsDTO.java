package com.tms.dal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@NoArgsConstructor@AllArgsConstructor
public class ContactDetailsDTO {

  private Long contactId;
  private String email;
  private String phoneNumber;
  private String mobileNumber;
  private String faxNumber;
  private String postalAddress;
  private String city;
  private String state;
  private String zipCode;
  private String country;
}
