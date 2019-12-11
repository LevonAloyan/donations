package com.sagittarius.donations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.sagittarius.donations.persistance.domain")
public class DonationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DonationsApplication.class, args);
	}

}
