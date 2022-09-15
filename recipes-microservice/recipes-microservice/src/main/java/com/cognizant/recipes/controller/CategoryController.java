package com.cognizant.recipes.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.recipes.dto.CategoryDto;
import com.cognizant.recipes.entities.Category;
import com.cognizant.recipes.service.CategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
@Slf4j
public class CategoryController {

	private final ModelMapper mapper;
	private final CategoryService categoryService;

	@PostMapping("/add")
	public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto) {
		log.info("*** Adding Category Starts ***");

		Category responseCategory = mapper.map(categoryDto, Category.class);
		Category createdCategory = categoryService.addCategory(responseCategory);
		CategoryDto requestCategory = mapper.map(createdCategory, CategoryDto.class);
		
		log.info("*** Adding Category Ends ***");

		return new ResponseEntity<CategoryDto>(requestCategory, HttpStatus.CREATED);
	}
}
