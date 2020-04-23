package com.hunter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ViewConfiguration {

	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
	
	@Bean
	public SpringSecurityDialect securityDialect() {
	    return new SpringSecurityDialect();
	}

}
