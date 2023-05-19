package com.tms;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(DiscoveryServerApplication.class).run(args);
    }
}
