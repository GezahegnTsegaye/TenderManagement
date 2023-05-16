package com.tms.notification;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "notification",
        url = "${clients.notification.url}"
)
public interface NotificationClient {

  @PostMapping("api/notification")
  void sendNotification(NotificationRequest notificationRequest);


}
