package com.cognizant.recipes.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cognizant.recipes.entities.Recipe;
import com.cognizant.recipes.repository.RecipeRepository;
import com.cognizant.recipes.service.RecipeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;
	
	@Override
	public Recipe addRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	@Override
	public List<Recipe> getAllRecipes() {
		return recipeRepository.findAll();
	}

	@Override
	public Recipe getRecipe(Long id) {
		return recipeRepository.findById(id).get();
	}

	@Override
	public Recipe editRecipe(Long id, Recipe recipe) {
		Optional<Recipe> existedRecipe = recipeRepository.findById(id);
		if(existedRecipe.isPresent()) {
			recipeRepository.deleteById(id);
		}
		return null;
	}

	@Override
	public String deleteRecipe(Long id) {
		Optional<Recipe> existedRecipe = recipeRepository.findById(id);
		if(existedRecipe.isPresent()) {
			recipeRepository.deleteById(id);
			return "Recipe Deleted";
		}
		return "Something went wrong!!";
	}

}
