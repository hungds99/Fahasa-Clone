package com.hunter.controller.client;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hunter.dto.CartDTO;
import com.hunter.model.Customer;

@Controller
public class CartController {

	@PostMapping("/xac-nhan-don-hang")
	public String acceptBill (@ModelAttribute Customer customer, HttpServletRequest request, Model model) {
		HttpSession session = (HttpSession) request.getSession();
		List<CartDTO> carts = (List<CartDTO>) session.getAttribute("cart");
		ObjectMapper mapper = new ObjectMapper();
		try {
			String cartJson = mapper.writeValueAsString(carts);
			System.out.println(cartJson);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		model.addAttribute("carts", carts);
		return "redirect:/";
	}
	
}
