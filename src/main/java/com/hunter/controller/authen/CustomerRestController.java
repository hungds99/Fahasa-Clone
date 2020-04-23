package com.hunter.controller.authen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestParam;

//@RestController
public class CustomerRestController {

	@Autowired
	AuthenticationManager authenticationManager;

//	@PostMapping("/customer/signin")
	public String customerAuthSignin(@RequestParam("email") String email, @RequestParam("password") String password) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, password);

//		token.setDetails(details);
		try {
			Authentication auth = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(auth);
			return "login success";
		} catch (BadCredentialsException e) {
			return "bad credentials";
		}
	}

}
