package com.hunter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hunter.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
