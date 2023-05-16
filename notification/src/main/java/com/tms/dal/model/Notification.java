package com.tms.dal.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


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


  public Notification() {
  }

  public Notification(Integer notificationId, Integer toCustomerId, String toCustomerEmail, String sender, String message, LocalDateTime sentAt) {
    this.notificationId = notificationId;
    this.toCustomerId = toCustomerId;
    this.toCustomerEmail = toCustomerEmail;
    this.sender = sender;
    this.message = message;
    this.sentAt = sentAt;
  }

  public Integer getNotificationId() {
    return notificationId;
  }

  public void setNotificationId(Integer notificationId) {
    this.notificationId = notificationId;
  }

  public Integer getToCustomerId() {
    return toCustomerId;
  }

  public void setToCustomerId(Integer toCustomerId) {
    this.toCustomerId = toCustomerId;
  }

  public String getToCustomerEmail() {
    return toCustomerEmail;
  }

  public void setToCustomerEmail(String toCustomerEmail) {
    this.toCustomerEmail = toCustomerEmail;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public LocalDateTime getSentAt() {
    return sentAt;
  }

  public void setSentAt(LocalDateTime sentAt) {
    this.sentAt = sentAt;
  }

  @Override
  public String toString() {
    return "Notification{" + "notificationId=" + notificationId +
            ", toCustomerId=" + toCustomerId +
            ", toCustomerEmail='" + toCustomerEmail + '\'' +
            ", sender='" + sender + '\'' +
            ", message='" + message + '\'' +
            ", sentAt=" + sentAt +
            '}';
  }
}
