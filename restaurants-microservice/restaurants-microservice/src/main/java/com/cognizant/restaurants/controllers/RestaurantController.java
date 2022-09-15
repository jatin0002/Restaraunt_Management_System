package com.cognizant.restaurants.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.restaurants.dto.RestaurantDto;
import com.cognizant.restaurants.entites.Restaurant;
import com.cognizant.restaurants.services.RestaurantService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/restaurant")
@RequiredArgsConstructor
@Slf4j
public class RestaurantController {

	private final ModelMapper mapper;
	private final RestaurantService restaurantService;

	@PostMapping("/new")
	public ResponseEntity<RestaurantDto> createRestaurant(@Valid @RequestBody RestaurantDto restaurantDto) {
		log.info("*** Create Restaurant Start ***");
System.out.println(restaurantDto);
		Restaurant restaurantResponse = mapper.map(restaurantDto, Restaurant.class);
		Restaurant createdRestaurant = restaurantService.createRestaurant(restaurantResponse);
		RestaurantDto restaurantRequest = mapper.map(createdRestaurant, RestaurantDto.class);

		log.info("*** Create Restaurant End ***");
		return new ResponseEntity<RestaurantDto>(restaurantRequest, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
		log.info("*** Fetching All Restaurant Start ***");

		List<RestaurantDto> restaurantRequestList = restaurantService.getAllRestaurants().stream()
				.map(res -> mapper.map(res, RestaurantDto.class)).collect(Collectors.toList());

		log.info("*** Fetching All Restaurant End ***");
		return new ResponseEntity<List<RestaurantDto>>(restaurantRequestList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RestaurantDto> getRestaurant(@PathVariable("id") Long restaurantId) {
		log.info("*** Fetching Restaurant By Id Start ***");

		Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
		RestaurantDto restaurantRequest = mapper.map(restaurant, RestaurantDto.class);

		log.info("*** Fetching Restaurant By Id End ***");
		return new ResponseEntity<RestaurantDto>(restaurantRequest, HttpStatus.OK);
	}

	@PutMapping("/edit/{id}")
	public ResponseEntity<RestaurantDto> updateRestaurant(@Valid @PathVariable("id") Long restaurantId,
			@RequestBody RestaurantDto restaurantDto) {
		log.info("*** Updating Restaurant Start ***");

		Restaurant restaurantResponse = mapper.map(restaurantDto, Restaurant.class);
		Restaurant updatedRestaurant = restaurantService.editRestaurant(restaurantId, restaurantResponse);
		RestaurantDto restaurantRequest = mapper.map(updatedRestaurant, RestaurantDto.class);

		log.info("*** Updating Restaurant End ***");
		return new ResponseEntity<RestaurantDto>(restaurantRequest, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}/change")
	public ResponseEntity<RestaurantDto> statusRestaurant(@Valid @PathVariable("id") Long restaurantId,
			@RequestParam(value = "status") Boolean status ) {
		log.info("*** Change Restaurant Status Start ***");
		
		Restaurant updatedRestaurant = restaurantService.changeRestaurantStatus(restaurantId, status);
		RestaurantDto restaurantRequest = mapper.map(updatedRestaurant, RestaurantDto.class);
		
		log.info("*** Change Restaurant Status End ***");
		return new ResponseEntity<RestaurantDto>(restaurantRequest, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteRestaurant(@PathVariable("id") Long restaurantId) {
		log.info("*** Deleting Restaurant Start ***");

		String response = restaurantService.deleteRestaurant(restaurantId);

		log.info("*** Updating Restaurant End ***");
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}
}