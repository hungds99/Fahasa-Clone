package com.hunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunter.model.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {

}
