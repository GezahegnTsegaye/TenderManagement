package com.tms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EntityScan("com.tms.dal.models")
public class TendererApplication {
    public static void main(String[] args) {
        SpringApplication.run(TendererApplication.class, args);
    }
}
