package com.hunter.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hunter.dto.ProductCatalog;
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

	@GetMapping("/api/catalog")
	public List<ProductViewDTO> getOrderProducts(int category_id, String order_by, int page, int limit) {
		
		List<ProductViewDTO> productViewDTOs = productService.getProductByOrder(category_id, order_by, page, limit);
		
		return productViewDTOs;
	}

	@GetMapping("/api/catalog/{categoryId}")
	public ProductCatalog getProductCatalog(@PathVariable("categoryId") int categoryId) {
		return productService.getProductCatalog(categoryId);
	}

	@GetMapping("/api/catalog/getData")
	public List<ProductViewDTO> getDataCatalog(@RequestParam("category_id") int categoryId,
			@RequestParam("sortBy") String sortBy) {

		System.out.println(categoryId);
		System.out.println(sortBy.equalsIgnoreCase("coming_soon"));

		List<ProductViewDTO> productViewDTOs = productService.getProductByCategoryIdSort(categoryId, sortBy);
		return productViewDTOs;
	}

}
