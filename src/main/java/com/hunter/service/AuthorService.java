package com.hunter.service;

import java.util.List;

import com.hunter.model.Author;

public interface AuthorService {

	public List<Author> findAll();
	
	public List<Author> findByAuthorName(String authorName, int begin, int end);
	
	public void save(Author author);
	
	public void deleteAllById(List<Integer> authorIds);
	
}
