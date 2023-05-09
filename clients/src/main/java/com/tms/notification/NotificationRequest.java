package com.tms.notification;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class NotificationRequest {

  private Long toCostumerId;
  private String toCustomerFullName;
  private String message;
}
