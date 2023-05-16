package com.tms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@EntityScan("com.tms.dal.models")
@EnableEurekaClient
//@PropertySources({
//        @PropertySource("classpath:clients-${spring.profiles.active}.properties")
//})
public class TendererApplication {
    public static void main(String[] args) {
        SpringApplication.run(TendererApplication.class, args);
    }
}
