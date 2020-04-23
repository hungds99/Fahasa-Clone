package com.hunter.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunter.model.Customer;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findByEmail(String email);
	
}
