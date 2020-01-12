package com.Dodon.Gatea.Saas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
@EntityScan
public class SaasApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SaasApplication.class, args);
	}

}
