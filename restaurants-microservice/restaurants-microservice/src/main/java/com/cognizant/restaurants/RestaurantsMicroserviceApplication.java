package com.cognizant.restaurants;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestaurantsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantsMicroserviceApplication.class, args);
	}

	@Bean
	ModelMapper mapper() {
		return new ModelMapper();
	}
	
}
