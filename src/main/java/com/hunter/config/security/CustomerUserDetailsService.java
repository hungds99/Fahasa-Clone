package com.hunter.config.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hunter.model.Customer;
import com.hunter.repository.CustomerRepository;

@Component("customerUserDetailsService")
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Username: " + email + " not found"));

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new User(customer.getEmail(), customer.getPassword(), grantedAuthorities);
	}

}
