package com.hunter.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hunter.dto.ProductViewDTO;
import com.hunter.service.CategoryService;
import com.hunter.service.ProductService;
import com.hunter.utils.ViewName;

@Controller
@RequestMapping("/")
public class ClientController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;

	@GetMapping
	public String getHomePage(Model model) {
		return ViewName.CLIENT_HOME_PAGE;
	}
	
	@GetMapping("san-pham/{productId}")
	public String getDetailPage(@PathVariable("productId") int productId, Model model) {
		System.out.println(productId);
		ProductViewDTO productViewDTO = productService.getProductByProductId(productId);
		model.addAttribute("product", productViewDTO);
		return ViewName.CLIENT_DETAIL_PAGE;
	}
	
	@GetMapping("danh-muc/{categoryId}")
	public String getCategoryProductPage(@PathVariable("categoryId") int categoryId, Model model) {
		System.out.println(categoryId);
		return ViewName.CLIENT_LIST_PAGE;
	}
	
}
