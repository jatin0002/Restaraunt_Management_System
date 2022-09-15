package com.cognizant.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.recipes.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe	,Long> {

}
