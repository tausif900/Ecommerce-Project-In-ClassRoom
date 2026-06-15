package com.study.ecommerce;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.study.ecommerce.entities.Product;

@SpringBootApplication

//	Indicates a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning. This is a convenience annotation that is equivalent to declaring @SpringBootConfiguration , @EnableAutoConfiguration and @ComponentScan .
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);

	}

//	ModelMapper is an intelligent Java object-mapping library used in Spring Boot to automatically copy data between different object models, most commonly between Database Entities and Data Transfer Objects (DTOs).

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
