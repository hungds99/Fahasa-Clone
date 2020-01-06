package com.hunter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hunter.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	
	@Query(value = "SELECT * FROM author a WHERE a.author_name LIKE %?1% LIMIT ?2, ?3", nativeQuery = true)
	List<Author> findByAuthorName(String authorName, int begin, int end);
	
}
