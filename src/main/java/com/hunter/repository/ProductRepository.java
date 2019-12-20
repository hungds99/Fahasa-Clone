package com.hunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunter.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	
}
