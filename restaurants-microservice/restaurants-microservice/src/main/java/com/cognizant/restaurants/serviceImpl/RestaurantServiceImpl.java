package com.cognizant.restaurants.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cognizant.restaurants.entites.Restaurant;
import com.cognizant.restaurants.repository.RestaurantRepository;
import com.cognizant.restaurants.services.RestaurantService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

	private final RestaurantRepository repository;

	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		restaurant.setIsClosed(true);
		return repository.save(restaurant);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		return repository.findAll();
	}

	@Override
	public Restaurant getRestaurantById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public Restaurant editRestaurant(Long id, Restaurant restaurant) {
		Optional<Restaurant> existedRestaurant = repository.findById(id);

		Restaurant updatedRestaurant = null;
		if (existedRestaurant.isPresent()) {
			existedRestaurant.get().setRestaurantName(restaurant.getRestaurantName());
			existedRestaurant.get().setRestaurantLoction(restaurant.getRestaurantLoction());
			existedRestaurant.get().setOpeningTime(restaurant.getOpeningTime());
			existedRestaurant.get().setClosingTime(restaurant.getClosingTime());
			existedRestaurant.get().setFoodType(restaurant.getFoodType());

			updatedRestaurant = repository.save(existedRestaurant.get());
		}
		return updatedRestaurant;
	}

	@Override
	public String deleteRestaurant(Long id) {
		Optional<Restaurant> existedRestaurant = repository.findById(id);
		if(existedRestaurant.isPresent()) {
			repository.deleteById(id);;
			return "Restaurant Deleted";
		}
		return "Something went wrong!!";
	}

	@Override
	public Restaurant changeRestaurantStatus(Long id, Boolean status) {
		Optional<Restaurant> existedRestaurant = repository.findById(id);

		Restaurant updatedRestaurant = null;
		if (existedRestaurant.isPresent()) {
			existedRestaurant.get().setIsClosed(status);
			updatedRestaurant = repository.save(existedRestaurant.get());
		}
		return updatedRestaurant;
	}

}
