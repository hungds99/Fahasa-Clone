package com.hunter.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hunter.dto.ProductResponse;
import com.hunter.dto.ProductViewDTO;
import com.hunter.service.ProductService;

@RestController
public class ClientAPIController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/api/personal/suggestion")
	public List<ProductResponse> getProductSuggestion(@RequestParam("cat_id") int categoryId) {
		return null;
	}
	
	@GetMapping("/api/tabslider/index/getdata")
	public List<ProductViewDTO> getData(@RequestParam("category_id") int categoryId) {
		
		List<ProductViewDTO> productViewDTOs = productService.getProductByCategoryId(categoryId);
		
		return productViewDTOs;
	}
	
}
