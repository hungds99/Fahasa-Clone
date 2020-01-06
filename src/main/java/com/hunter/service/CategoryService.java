package com.hunter.service;

import java.util.List;

import com.hunter.model.Category;

public interface CategoryService {

	public List<Category> findAll();

	public List<Category> findByCategoryName(String categoryName, int begin, int end);

	public Category findById(int id);

	public void saveAndUpdate(Category category);

	public void deleteCategory(int id);

}
