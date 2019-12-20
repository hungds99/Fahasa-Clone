package com.hunter.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hunter.model.Author;
import com.hunter.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	@Override
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	@Override
	@Transactional
	public List<Author> findByAuthorName(String authorName, Pageable pageable) {
		Page<Author> authorPage = authorRepository.findByAuthorName(authorName, pageable);
		List<Author> authors = authorPage.getContent();
		return authors;
	}

	@Override
	public void save(Author author) {
		authorRepository.save(author);
	}

	@Override
	@Transactional
	public void deleteAllById(List<Integer> authorIds) {
		List<Author> authors = new ArrayList<Author>();
		
		for (Integer authorId : authorIds) {
			Author author = new Author();
			author.setId(authorId);
			authors.add(author);
		}
		authorRepository.deleteAll(authors);
	}
	
}
