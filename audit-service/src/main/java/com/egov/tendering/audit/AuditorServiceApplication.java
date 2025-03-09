package com.egov.tendering.audit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class AuditorServiceApplication {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(AuditorServiceApplication.class);
//		application.setAdditionalProfiles("dev");
		application.run(args);
	}

}
