package com.cognizant.restaurants.dto;

import java.time.LocalTime;
import java.util.ArrayList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDto {

	private Long restaurantId;

	@NotBlank(message = "Restaurant name can not be blank.")
	private String restaurantName;

	@NotBlank(message = "Restaurant location can not be blank.")
	private String restaurantLoction;

	private Boolean isClosed ;
	
	@NotNull(message = "Opening timing can not be blank.")
	private LocalTime openingTime;
	@NotNull(message = "Closing timing can not be blank.")
	private LocalTime closingTime;
	
	@NotEmpty(message = "Food type can not be blank.")
	private ArrayList<String> foodType; // veg / non-veg / pure-veg
}
