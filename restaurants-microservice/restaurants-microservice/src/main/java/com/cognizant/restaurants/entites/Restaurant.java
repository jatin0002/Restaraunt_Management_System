package com.cognizant.restaurants.entites;

import java.time.LocalTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long restaurantId;

	@Column(name = "name")
	private String restaurantName;

	@Column(name = "location")
	private String restaurantLoction;

	private Boolean isClosed;
	
	private LocalTime openingTime;
	private LocalTime closingTime;
	
	private ArrayList<String> foodType; // veg / non-veg / pure-veg
	
}
