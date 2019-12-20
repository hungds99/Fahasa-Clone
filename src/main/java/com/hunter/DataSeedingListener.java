package com.hunter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.hunter.model.User;
import com.hunter.repository.UserRepository;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		if (userRepository.findAll().isEmpty()) {
			User user = new User();
			user.setUsername("Dinh Sy Hung");
			user.setEmail("dinhsyhung99@gmail.com");
			user.setPassword(passwordEncoder.encode("1234"));
			userRepository.save(user);
		}
		
	}

}
