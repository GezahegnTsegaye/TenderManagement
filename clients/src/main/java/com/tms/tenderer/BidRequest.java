package com.tms.tenderer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@NoArgsConstructor@Getter@AllArgsConstructor
public class BidRequest {

  private Long toBiderId;
  private String toBidFullName;
  private  String message;
}
