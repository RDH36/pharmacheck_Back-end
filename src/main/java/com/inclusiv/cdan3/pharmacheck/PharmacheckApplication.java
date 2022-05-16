package com.inclusiv.cdan3.pharmacheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PharmacheckApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacheckApplication.class, args);
	}

}
