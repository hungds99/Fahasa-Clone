package com.hunter.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hunter.dto.ProductViewDTO;
import com.hunter.service.ProductService;

@RestController
public class TransactionAPITest {

	@Autowired
	ProductService productService;
	
	@GetMapping("/api/transaction/getProducts")
	public List<ProductViewDTO> getListProductByCategoryId(@RequestParam("category_id") int categoryId) {
		List<ProductViewDTO> productViewDTOs = productService.getProductByCategoryId(categoryId);
		return productViewDTOs;
	}
	
}
