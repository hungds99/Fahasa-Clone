package com.hunter.service;

import java.util.List;

import com.hunter.dto.CartDTO;
import com.hunter.dto.OrderDTO;
import com.hunter.model.Customer;

public interface OrderService {

	public void saveOrder(Customer customer, List<CartDTO> carts);
	
	List<OrderDTO> orderInfo(int customerId);
	
	public List<OrderDTO> findAllByOrder(int orderId, int begin, int end);
	
	OrderDTO orderCustomerInfo(int orderId);
	
}
