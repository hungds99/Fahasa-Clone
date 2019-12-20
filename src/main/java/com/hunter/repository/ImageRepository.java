package com.hunter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunter.model.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

	List<Image> findByProductId(int productId);
	
}
