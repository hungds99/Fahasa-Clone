package com.hunter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunter.dto.CartDTO;
import com.hunter.model.Customer;
import com.hunter.model.OrderCustomer;
import com.hunter.repository.CustomerRepository;
import com.hunter.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderDetailService orderDetailService;

	@Override
	@Transactional
	public void saveOrder(Customer customer, List<CartDTO> carts) {
		OrderCustomer order = new OrderCustomer();

		Customer customerExisted = customerRepository.findById(customer.getId()).orElse(null);
		if (customerExisted == null) {
			return;
		}

		order.setCustomer(customerExisted);

		OrderCustomer orderSaved = orderRepository.save(order);

		for (CartDTO cart : carts) {
			orderDetailService.saveOrderDetail(cart, orderSaved);
		}

	}

}
