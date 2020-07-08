package com.hunter.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hunter.dto.OrderDTO;
import com.hunter.service.OrderService;
import com.hunter.utils.ViewName;

@Controller
@RequestMapping("/Admin")
public class AdminOrderController {

	@Autowired
	OrderService orderService;

	@GetMapping("/Order/List")
	public String getOrderList() {
		
		return ViewName.ADMIN_ORDER_PAGE;
	}
	
	@PostMapping("/Order/List")
	@ResponseBody
	public List<OrderDTO> getOrders(@RequestParam("keyword") int keyword ,@RequestParam("page") int page) {
		List<OrderDTO> orders = orderService.findAllByOrder(keyword, page - 1, 10);
		return orders;
	}
	
	@GetMapping("/Order/Detail/{orderId}")
	@ResponseBody
	public OrderDTO getOrderDetail(@PathVariable("orderId") int orderId) {
		return orderService.orderCustomerInfo(orderId);
	}
}
