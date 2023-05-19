package com.tms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"com.tms.dal"})
@EntityScan("com.tms.dal.model")
public class TendereeApplication {


  public static void main(String[] args) {
    SpringApplication.run(TendereeApplication.class, args);
  }
}
