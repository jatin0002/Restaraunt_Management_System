package com.cognizant.recipes.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeDto {
	private  Long recipeId;
	
	private String recipeName;
	private Double price;
	private String picture;
	private String foodType;
	private CategoryDto category;
}
