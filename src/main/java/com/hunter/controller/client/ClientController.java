package com.hunter.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hunter.service.CategoryService;
import com.hunter.utils.ViewName;

@Controller
@RequestMapping("/")
public class ClientController {
	
	@Autowired
	CategoryService categoryService;

	@GetMapping
	public String getHomePage(Model model) {
		return  ViewName.CLIENT_HOME_PAGE;
	}
	
}
