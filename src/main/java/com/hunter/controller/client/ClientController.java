package com.hunter.controller.client;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hunter.dto.CartDTO;
import com.hunter.dto.ProductViewDTO;
import com.hunter.model.Customer;
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
	public String getHomePage(Model model,HttpServletRequest request) {
		HttpSession session = (HttpSession) request.getSession();
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");
		System.out.println(carts);
		model.addAttribute("carts", carts);
		model.addAttribute("cartTotal", (carts == null) ? 0 : carts.size());
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			System.out.println(authentication);
			System.out.println("?");
		    Object currentUserName = authentication.getPrincipal();
		    System.out.println(currentUserName.toString());
		}
		
		return ViewName.CLIENT_HOME_PAGE;
	}
	
	@GetMapping("san-pham/{productId}")
	public String getDetailPage(@PathVariable("productId") int productId, Model model, HttpServletRequest request) {
		ProductViewDTO productViewDTO = productService.getProductByProductId(productId);
		
		HttpSession session = (HttpSession) request.getSession();
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");
		
		model.addAttribute("product", productViewDTO);
		model.addAttribute("carts", carts);
		model.addAttribute("cartTotal", (carts == null) ? 0 : carts.size());
		
		return ViewName.CLIENT_DETAIL_PAGE;
	}
	
	@GetMapping("danh-muc/{categoryId}")
	public String getCategoryProductPage(@PathVariable("categoryId") int categoryId, Model model) {
		System.out.println(categoryId);
		return ViewName.CLIENT_LIST_PAGE;
	}
	
	@GetMapping("kiem-tra-gio-hang")
	public String getCartPage(HttpServletRequest request,  Model model) {
		HttpSession session = (HttpSession) request.getSession();
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");
		
		model.addAttribute("carts", carts);
		model.addAttribute("cartTotal", (carts == null) ? 0 : carts.size());
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			System.out.println(authentication);
			System.out.println("?");
		    Object currentUserName = authentication.getPrincipal();
		    System.out.println(currentUserName.toString());
		}
		
		return ViewName.CLIENT_CART_PAGE;
	}
	
	@GetMapping("tien-hanh-thanh-toan")
	public String getPaymentPage(HttpServletRequest request,  Model model) {
		HttpSession session = (HttpSession) request.getSession();
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");
		
		model.addAttribute("customer", new Customer());
		model.addAttribute("carts", carts);
		model.addAttribute("cartTotal", (carts == null) ? 0 : carts.size());
		
		return ViewName.CLIENT_PAYMENT_PAGE;
	}
	
}
