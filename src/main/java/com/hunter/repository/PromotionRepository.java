package com.hunter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hunter.model.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

	@Query("FROM Promotion")
	List<Promotion> findAllPromotion();
	
}
