package com.hunter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunter.model.Customer;
import com.hunter.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void saveOrEdit(Customer customer) {
		Customer customerExisted = customerRepository.findById(customer.getId()).orElse(null);
		
		if (customerExisted == null) {
			customerRepository.save(customer);
			return ;
		}
		
		customerExisted.setName(customer.getName());
		customerExisted.setPhone(customer.getPhone());
		customerExisted.setAddress(customer.getAddress());
		customerExisted.setEmail(customer.getEmail());
		customerExisted.setBirthday(customer.getBirthday());
		customerExisted.setGender(customer.getGender());
		
		customerRepository.save(customerExisted);
		
	}

}
