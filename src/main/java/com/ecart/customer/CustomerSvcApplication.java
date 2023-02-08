package com.ecart.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class CustomerSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerSvcApplication.class, args);
	}
	
}
