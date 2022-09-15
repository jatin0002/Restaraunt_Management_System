package com.cognizant.recipes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long recipeId;
	
	private String recipeName;
	private Double price;
	private String picture;
	private String foodType;
	
	@OneToOne()
    @JoinColumn(name = "category_id",
    referencedColumnName = "categoryId")
	private Category category;
}
