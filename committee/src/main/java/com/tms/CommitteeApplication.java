package com.tms;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tms.dal.model")
public class CommitteeApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(CommitteeApplication.class).run(args);
    }
}
