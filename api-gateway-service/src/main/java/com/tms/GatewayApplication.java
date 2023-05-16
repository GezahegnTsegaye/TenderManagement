package com.tms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableEurekaClient
@SpringBootApplication
public class GatewayApplication {


    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
