package com.tms.service;


import com.tms.dal.model.Notification;
import com.tms.dal.repository.NotificationRepository;
import com.tms.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {

  private final NotificationRepository  notificationRepository;

  public void send(NotificationRequest notificationRequest){
    notificationRepository.save(
            Notification.builder()
                    .toCustomerId(notificationRequest.toCustomerId())
                    .toCustomerEmail(notificationRequest.toCustomerName())
                    .message(notificationRequest.message())
                    .sentAt(LocalDateTime.now())
                    .build()
    );
  }
}
