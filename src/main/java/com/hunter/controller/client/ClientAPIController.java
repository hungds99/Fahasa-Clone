package com.hunter.controller.client;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hunter.dto.ProductResponse;

@RestController
public class ClientAPIController {

	@PostMapping("/api/personal/suggestion")
	public List<ProductResponse> getProductSuggestion(@RequestParam("cat_id") int categoryId) {
		return null;
	}
	
}
