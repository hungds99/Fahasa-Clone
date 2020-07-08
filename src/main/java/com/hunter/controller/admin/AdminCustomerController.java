package com.hunter.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hunter.dto.OrderDTO;
import com.hunter.model.Customer;
import com.hunter.service.CustomerService;
import com.hunter.service.OrderService;
import com.hunter.utils.ViewName;

@Controller
@RequestMapping("/Admin")
public class AdminCustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;

	@GetMapping("/Customer/List")
	public String getCustomerList(Model model) {
		
		return ViewName.ADMIN_CUSTOMER_PAGE;
	}
	
	@PostMapping("/Customer/List")
	@ResponseBody
	public List<Customer> getCustomers(@RequestParam("keyword") String keyword ,@RequestParam("page") int page) {
		List<Customer> authors = customerService.findByCustomerName(keyword, page - 1, 10);
		return authors;
	}
	
	@GetMapping("/Customer/GetOne/{id}")
	@ResponseBody
	public Customer getCustomer(@PathVariable("id") int id) {
		return customerService.findCustomerById(id);
	}
	
	@GetMapping("/Customer/Order/History/{id}")
	@ResponseBody
	public List<OrderDTO> getOrderCustomer(@PathVariable("id") int id) {
		return orderService.orderInfo(id);
	}
	
}
