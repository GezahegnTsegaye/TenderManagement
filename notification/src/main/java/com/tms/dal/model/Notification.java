package com.tms.dal.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class Notification {
  @Id
  @SequenceGenerator(
          name = "notification_id_sequence",
          sequenceName = "notification_id_sequence"
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "notification_id_sequence"
  )
  private Integer notificationId;
  private Integer toCustomerId;
  private String toCustomerEmail;
  private String sender;
  private String message;
  private LocalDateTime sentAt;
}
