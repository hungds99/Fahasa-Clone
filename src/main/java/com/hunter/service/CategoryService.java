package com.hunter.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.hunter.model.Category;

public interface CategoryService {

	public List<Category> findAll();

	public List<Category> findByCategoryName(String categoryName, Pageable pageable);

	public Category findById(int id);

	public void saveAndUpdate(Category category);

	public void deleteCategory(int id);

}
