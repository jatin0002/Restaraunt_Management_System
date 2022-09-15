package com.cognizant.recipes.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.recipes.dto.RecipeDto;
import com.cognizant.recipes.entities.Recipe;
import com.cognizant.recipes.service.RecipeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/recipe")
@RequiredArgsConstructor
@Slf4j
public class RecipeController {
	private final ModelMapper mapper;
	private final RecipeService recipeService;

	@PostMapping("/add")
	public ResponseEntity<RecipeDto> addRecipe(@RequestBody RecipeDto recipeDto) {
		log.info("*** Adding Recipe Starts ***");

		Recipe responseRecipe = mapper.map(recipeDto, Recipe.class);
		Recipe createdRecipe = recipeService.addRecipe(responseRecipe);
		RecipeDto requestRecipe = mapper.map(createdRecipe, RecipeDto.class);

		log.info("*** Adding Recipe Ends ***");
		return new ResponseEntity<RecipeDto>(requestRecipe, HttpStatus.CREATED);
	}
}
