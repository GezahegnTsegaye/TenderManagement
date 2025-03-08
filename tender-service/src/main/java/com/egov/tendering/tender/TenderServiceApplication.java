package com.egov.tendering.tender;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TenderServiceApplication {
  public static void main(String[] args) {
    System.setProperty("spring.profiles.active", "dev");
    SpringApplication.run(TenderServiceApplication.class, args);
  }
}
