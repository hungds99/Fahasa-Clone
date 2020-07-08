package com.hunter.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hunter.model.Customer;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findByEmail(String email);
	
	@Query(value = "SELECT * FROM customer c WHERE c.name LIKE %?1% LIMIT ?2, ?3", nativeQuery = true)
	List<Customer> findByCustomerName(String authorName, int begin, int end);
	
}
