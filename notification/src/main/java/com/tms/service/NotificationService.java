package com.tms.service;


import com.tms.dal.repository.NotificationRepository;
import com.tms.notification.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

  private final NotificationRepository  notificationRepository;

  public void send(NotificationRequest notificationRequest){

  }
}
