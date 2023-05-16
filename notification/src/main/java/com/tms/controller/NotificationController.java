package com.tms.controller;

import com.tms.notification.NotificationRequest;
import com.tms.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notification")
public class NotificationController {

  private final NotificationService notificationService;
  private final static Logger log = LoggerFactory.getLogger(NotificationController.class);

  public NotificationController(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @PostMapping
  public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
    log.info("New notification... {}", notificationRequest);
    notificationService.send(notificationRequest);
  }
}
