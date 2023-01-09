package com.prospecta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan({"com.prospecta.controller","com.prospecta.service"})
public class ProspectaSpringAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProspectaSpringAssignmentApplication.class, args);
	}

	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
}
