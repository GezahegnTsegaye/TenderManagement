package com.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TMApplication {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(TMApplication.class);
		application.setAdditionalProfiles("dev");
		application.run(args);
	}

}
