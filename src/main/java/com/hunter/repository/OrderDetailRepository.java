package com.hunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunter.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

	
}
