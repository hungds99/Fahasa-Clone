package com.hunter.controller.client;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hunter.utils.ViewName;

@ControllerAdvice
public class ErrorControllerHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(Exception.class)
	public String handle404NotFound() {
		
		return ViewName.CLIENT_404_ERROR_PAGE;
	}
	
}
