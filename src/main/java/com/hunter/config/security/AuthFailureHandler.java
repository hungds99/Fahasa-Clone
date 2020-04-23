package com.hunter.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		System.out.println("login failer");
		
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("password"));
		
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.getWriter().print("{\"success\": false}");
		response.getWriter().flush();

	}

}
