package com.hunter.service;

import java.util.List;

import com.hunter.model.Publisher;

public interface PublisherService {

	public List<Publisher> findAll();
	
	List<Publisher> findByPublisherName(String publisherName, int begin, int end);
	
	void save(Publisher publisher);
	
}
