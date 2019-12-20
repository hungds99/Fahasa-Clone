package com.hunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunter.model.ProductAttribute;

public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Integer> {

	ProductAttribute findByProductId(int productId);
	
}
