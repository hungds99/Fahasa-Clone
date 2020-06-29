package com.hunter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunter.dto.CartDTO;
import com.hunter.model.OrderCustomer;
import com.hunter.model.OrderDetail;
import com.hunter.model.Product;
import com.hunter.repository.OrderDetailRepository;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Override
	public void saveOrderDetail(CartDTO cart, OrderCustomer order) {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setOrder(order);
		
		Product product = new Product();
		product.setId(cart.getProductId());
		
		orderDetail.setProduct(product);
		
		orderDetail.setOrderAmount(cart.getProductAmount());
		
		orderDetail.setOrderPrice(cart.getProductPrice());
		
		orderDetailRepository.save(orderDetail);
	}

}
