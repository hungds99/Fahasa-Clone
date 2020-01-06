package com.hunter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hunter.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

	@Query(value = "SELECT * FROM publisher a WHERE a.publisher_name LIKE %?1% LIMIT ?2, ?3", nativeQuery = true)
	List<Publisher> findByPublisherName(String publisherName, int begin, int end);
	
}
