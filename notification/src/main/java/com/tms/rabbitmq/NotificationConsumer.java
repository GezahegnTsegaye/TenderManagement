package com.tms.rabbitmq;

import com.tms.notification.NotificationRequest;
import com.tms.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

  private final NotificationService notificationService;
  private static final  Logger log = LoggerFactory.getLogger(NotificationConsumer.class);

  public NotificationConsumer(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @RabbitListener(queues = "${rabbitmq.queues.notification}")
  public void consumer(NotificationRequest notificationRequest) {
    log.info("Consumed {} from queue", notificationRequest);
    notificationService.send(notificationRequest);
  }
}