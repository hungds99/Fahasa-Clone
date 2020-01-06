package com.hunter.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunter.model.ProductAttribute;
import com.hunter.repository.ProductAttributeRepository;

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {

	@Autowired
	ProductAttributeRepository productAttributeRepository;
	
	@Override
	public ProductAttribute findByProductId(int productId) {
		return productAttributeRepository.findByProductId(productId);
	}

	@Override
	@Transactional
	public ProductAttribute saveAndUpdate(ProductAttribute productAttribute) {
		ProductAttribute productAttributeExist = productAttributeRepository.findByProductId(productAttribute.getProductId());
		
		if (productAttributeExist != null) {
			productAttributeExist.setAttrCode(productAttribute.getAttrCode());
			productAttributeExist.setAuthor(productAttribute.getAuthor());
			productAttributeExist.setSupplier(productAttribute.getSupplier());
			productAttributeExist.setPublisher(productAttribute.getPublisher());
			productAttributeExist.setPublishYear(productAttribute.getPublishYear());
			productAttributeExist.setAttrLanguage(productAttribute.getAttrLanguage());
			productAttributeExist.setAttrSize(productAttribute.getAttrSize());
			productAttributeExist.setAttrLayout(productAttribute.getAttrLayout());
			return productAttributeRepository.save(productAttributeExist);
		}
		return productAttributeRepository.save(productAttribute);
	}
	
}
