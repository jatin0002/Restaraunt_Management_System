package com.cognizant.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.recipes.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
