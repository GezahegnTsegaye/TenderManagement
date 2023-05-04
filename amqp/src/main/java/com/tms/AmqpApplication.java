package com.tms;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AmqpApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(AmqpApplication.class).run(args);
    }
}
