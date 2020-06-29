package com.hunter.controller.client;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hunter.dto.CartDTO;
import com.hunter.model.Customer;
import com.hunter.service.OrderService;
import com.hunter.utils.ViewName;

@Controller
public class CartController {
	
	@Autowired
	OrderService orderService;

	@PostMapping("/tien-hanh-thanh-toan")
	public String acceptBill (@Valid @ModelAttribute Customer customer,BindingResult bindingResult, HttpServletRequest request, Model model) {
		
		HttpSession session = (HttpSession) request.getSession();
		@SuppressWarnings("unchecked")
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");
		
		model.addAttribute("carts", carts);
		model.addAttribute("cartTotal", (carts == null) ? 0 : carts.size());
		
		if (bindingResult.hasErrors()) {
			return ViewName.CLIENT_PAYMENT_PAGE;
		}
		
		
		orderService.saveOrder(customer, carts);
		
		return "redirect:/dat-hang-thanh-cong";
	}
	
	@GetMapping("/dat-hang-thanh-cong")
	public String orderSuccess() {
		return ViewName.CLIENT_ORDER_SUCCESS_PAGE;
	}
	
}
