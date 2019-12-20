package com.hunter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hunter.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	@Query(value = "SELECT * FROM category c WHERE c.category_name LIKE %?1%", nativeQuery = true)
	Page<Category> findByCategoryName(String categoryName, Pageable pageable);
	
}
