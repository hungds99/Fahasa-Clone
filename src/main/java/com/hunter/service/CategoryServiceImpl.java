package com.hunter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunter.dao.CategoryDAO;
import com.hunter.model.Category;
import com.hunter.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	@Transactional
	public List<Category> findByCategoryName(String categoryName, int begin, int end) {
		List<Category> categories = categoryRepository.findByCategoryName(categoryName, begin, end);
		return categories;
	}

	public Category findById(int id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void saveAndUpdate(Category category) {
		// Find exist Category
		Category categoryExits = this.findById(category.getId());
		String categoryBreadcrumb = "";

		if (category.getParentId() != 0) {
			categoryBreadcrumb = categoryDAO.findCategoryBreadcrumbByParentId(category.getParentId());
		}

		// Is existed
		if (categoryExits != null) {
			categoryExits.setCategoryName(category.getCategoryName());
			categoryExits.setTitle(category.getTitle());
			categoryExits.setCategoryBreadcrumb(categoryBreadcrumb + " >> " + category.getCategoryName());
			categoryExits.setDescriptions(category.getDescriptions());
			categoryExits.setParentId(category.getParentId());
			categoryRepository.save(categoryExits);
		} else {
			category.setCategoryBreadcrumb(categoryBreadcrumb + " >> " + category.getCategoryName());
			categoryRepository.save(category);
		}
	}

	@Override
	public void deleteCategory(int id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public List<Category> findByCategoryName(String categoryName) {
		return categoryRepository.findByCategoryName(categoryName);
	}

	@Override
	public Category findByParentId(int parentId) {
		return categoryRepository.findByParentId(parentId);
	}

}
