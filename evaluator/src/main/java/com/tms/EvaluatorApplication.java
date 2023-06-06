package com.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class EvaluatorApplication {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(EvaluatorApplication.class);
//		application.setAdditionalProfiles("dev");
		application.run(args);
	}

}
