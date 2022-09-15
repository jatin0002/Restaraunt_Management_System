package com.cognizant.recipes.service;

import java.util.List;

import com.cognizant.recipes.entities.Recipe;

public interface RecipeService {
	Recipe addRecipe(Recipe recipe);

	List<Recipe> getAllRecipes();

	Recipe getRecipe(Long id);

	Recipe editRecipe(Long id, Recipe recipe);

	String deleteRecipe(Long id);
}
