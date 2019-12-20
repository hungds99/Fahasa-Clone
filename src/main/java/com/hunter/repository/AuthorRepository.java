package com.hunter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hunter.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	
	@Query(value = "SELECT * FROM author a WHERE a.author_name LIKE %?1%", nativeQuery = true)
	Page<Author> findByAuthorName(String authorName, Pageable pageable);
	
}
