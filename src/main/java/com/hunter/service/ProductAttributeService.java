package com.hunter.service;

import com.hunter.model.ProductAttribute;

public interface ProductAttributeService {

	public ProductAttribute findByProductId(int productId);
	
	public ProductAttribute saveAndUpdate(ProductAttribute productAttribute);
	
}
