package com.cognizant.restaurants.services;

import java.util.List;

import com.cognizant.restaurants.entites.Restaurant;

public interface RestaurantService {
	// C- Create
	Restaurant createRestaurant(Restaurant restaurant);
	
	// R- Read
	List<Restaurant> getAllRestaurants();
	Restaurant getRestaurantById(Long id);
	
	// U- Update
	Restaurant editRestaurant(Long id, Restaurant restaurant);
	Restaurant changeRestaurantStatus(Long id, Boolean status);
	
	// D- Delete
	String deleteRestaurant(Long id);
	
}
