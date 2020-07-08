package com.hunter.service;

import java.util.List;

import com.hunter.model.Customer;

public interface CustomerService {
	
	void saveOrEdit(Customer customer);
	
	List<Customer> findByCustomerName(String authorName, int begin, int end);
	
	Customer findCustomerById(int id);

}
