package com.cognizant.recipes.service;

import java.util.List;

import com.cognizant.recipes.entities.Category;

public interface CategoryService {
	Category addCategory(Category category);

	List<Category> getAllCategory();

	Category getCategory(Long id);

	Category editCategory(Long id, Category category);

	String deleteCategory(Long id);
}
