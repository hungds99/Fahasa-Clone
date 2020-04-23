package com.hunter;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.hunter.model.Customer;
import com.hunter.model.User;
import com.hunter.repository.CustomerRepository;
import com.hunter.repository.UserRepository;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		if (userRepository.findAll().isEmpty()) {
			User user = new User();
			user.setUsername("Dinh Sy Hung");
			user.setEmail("dinhsyhung99@gmail.com");
			user.setPassword(passwordEncoder.encode("1234"));
			userRepository.save(user);
		}
		
		if (customerRepository.findAll().isEmpty()) {
			Customer customer = new Customer();
			customer.setName("Dinh Sy Hung");
			customer.setAddress("Ha Tinh");
			customer.setGender("1");
			customer.setBirthday(new Date(10/20/2002));
			customer.setPhone(2);
			customer.setEmail("hung@gmail.com");
			customer.setUsername("Jave");
			customer.setPassword(passwordEncoder.encode("1234"));
			customerRepository.save(customer);
		}
		
	}

}
