package com.egov.tendering.notification.config;

import com.egov.tendering.notification.service.SmsService.SmsSender;
import com.egov.tendering.notification.service.PushNotificationService.PushSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@Slf4j
public class NotificationConfig {

  @Bean
  @Profile("!test")
  public JavaMailSender mailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    // Configure mail properties - these should be set in application.yml
    // and injected via @Value or ConfigurationProperties in a real application
    mailSender.setHost("smtp.example.com");
    mailSender.setPort(587);
    mailSender.setUsername("notification@egov-tendering.com");
    mailSender.setPassword("password");

    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "false");

    return mailSender;
  }

  @Bean
  public SmsSender smsSender() {
    // This is a simple mock implementation for demonstration
    // In a real application, you would use an actual SMS gateway service
    return (phoneNumber, message) -> {
      log.info("Mock SMS sent to: {} with message: {}", phoneNumber, message);
    };
  }

  @Bean
  public PushSender pushSender() {
    // This is a simple mock implementation for demonstration
    // In a real application, you would use an actual push notification service
    return (userId, title, body, data) -> {
      log.info("Mock push notification sent to user: {} with title: {}, body: {}, data: {}",
              userId, title, body, data);
    };
  }
}