package com.tms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.tms", "com.tms.services", "com.tms.utility",
		"com.tms.security", "com.tms.exceptions" })
@EnableJpaRepositories({"com.tms.repository"})
@EntityScan({"com.tms.model"})
public class EvaluatorApplication {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(EvaluatorApplication.class);
		application.setAdditionalProfiles("dev");
		application.run(args);
	}

}
