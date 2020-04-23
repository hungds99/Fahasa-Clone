package com.hunter.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@Order(2)
public class UserSecurityConfig extends WebSecurityConfigurerAdapter 
{

    @Autowired
    @Qualifier("customerUserDetailsService")
    UserDetailsService userDetailsService;
    
    @Autowired
    AuthFailureHandler authFailureHandler;
    
    @Autowired
    AuthSuccessHandler authSuccessHandler;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

	@Override
    protected void configure(HttpSecurity http) throws Exception {
	
        http
        	.antMatcher("/customer/**")
        	.antMatcher("/**")
	        .authorizeRequests()	
	    	.antMatchers("/customer/**")
	    	.hasRole("USER")
	    	
    	.and()
        	.formLogin()
        	.loginProcessingUrl("/customer/signin")
        	.permitAll()
        	.usernameParameter("email")
        	.passwordParameter("password")
        	.failureHandler(authFailureHandler)
            .successHandler(authSuccessHandler)
	        
	    .and()
	    	.csrf().disable();
    }
	
}
