package com.tms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.tms.dal"})
public class TendererApplication {
  public static void main(String[] args) {
    SpringApplication.run(TendererApplication.class, args);
  }
}
