package com.hunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunter.model.OrderCustomer;

public interface OrderRepository extends JpaRepository<OrderCustomer, Integer> {

}
