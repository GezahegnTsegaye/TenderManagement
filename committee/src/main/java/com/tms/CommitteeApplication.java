package com.tms;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CommitteeApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(CommitteeApplication.class).run(args);
    }
}
