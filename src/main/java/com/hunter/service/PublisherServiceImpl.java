package com.hunter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunter.model.Publisher;
import com.hunter.repository.PublisherRepository;

@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	PublisherRepository publisherRepository;

	@Override
	public List<Publisher> findAll() {
		return publisherRepository.findAll();
	}

	@Override
	public List<Publisher> findByPublisherName(String publisherName, int begin, int end) {
		return publisherRepository.findByPublisherName(publisherName, begin, end);
	}

	@Override
	public void save(Publisher publisher) {
		publisherRepository.save(publisher);
	}

}
