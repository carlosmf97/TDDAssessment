package com.assessment.flight.flight.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages={"com.assessment.flight.flight.assessment.flights", "com.assessment.flight.flight.assessment"})
public class Application{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
