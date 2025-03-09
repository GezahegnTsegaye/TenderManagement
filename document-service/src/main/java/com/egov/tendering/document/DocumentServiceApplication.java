package com.egov.tendering.document;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DocumentServiceApplication {


    public static void main(String[] args) {
        new SpringApplicationBuilder(DocumentServiceApplication.class).run(args);
    }
}
