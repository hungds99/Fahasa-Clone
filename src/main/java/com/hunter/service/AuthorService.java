package com.hunter.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.hunter.model.Author;

public interface AuthorService {

	public List<Author> findAll();
	
	public List<Author> findByAuthorName(String authorName, Pageable pageable);
	
	public void save(Author author);
	
}
