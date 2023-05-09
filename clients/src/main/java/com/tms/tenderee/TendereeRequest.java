package com.tms.tenderee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class TendereeRequest {


  private Long toCostumerId;
  private String toCustomerFullName;
  private String message;
}
