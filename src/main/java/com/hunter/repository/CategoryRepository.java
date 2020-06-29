package com.hunter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hunter.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	@Query(value = "SELECT * FROM category c WHERE c.category_name LIKE %?1% LIMIT ?2, ?3", nativeQuery = true)
	List<Category> findByCategoryName(String categoryName, int begin, int end);
	
	@Query(value = "SELECT * FROM category c WHERE c.category_name LIKE %?1%", nativeQuery = true)
	List<Category> findByCategoryName(String categoryName);
	
	Category findByParentId(int id);
	
	List<Category> findAllById(int id);
	
	List<Category> findAllByParentId(int parentId);

}
