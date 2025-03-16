package com.hiberus.hiring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"com.hiberus.hiring.*"})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TechnicalTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnicalTestApplication.class, args);
	}

}
