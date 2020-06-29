package com.hunter.service;

import com.hunter.dto.CartDTO;
import com.hunter.model.OrderCustomer;

public interface OrderDetailService {

	public void saveOrderDetail(CartDTO product, OrderCustomer order);
	
}
