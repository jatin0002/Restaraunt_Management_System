package com.cognizant.recipes;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecipesMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipesMicroserviceApplication.class, args);
	}

	@Bean
	ModelMapper mapper() {
		return new ModelMapper();
	}

}
