package com.cognizant.recipes.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cognizant.recipes.entities.Category;
import com.cognizant.recipes.repository.CategoryRepository;
import com.cognizant.recipes.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;
	@Override
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategory(Long id) {
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category editCategory(Long id, Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCategory(Long id) {
		Optional<Category> existedRecipe = categoryRepository.findById(id);
		if(existedRecipe.isPresent()) {
			categoryRepository.deleteById(id);
			return "Category Deleted";
		}
		return "Something went wrong!!";
	}

}
