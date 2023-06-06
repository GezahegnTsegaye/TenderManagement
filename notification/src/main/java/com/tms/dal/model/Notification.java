package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Setter@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "notification")
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
