package com.hunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunter.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
