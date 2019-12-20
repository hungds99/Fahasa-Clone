package com.hunter.service;

import java.util.List;

import com.hunter.model.Image;

public interface ImageService {

	public List<Image> findByProductId(int productId);
	
	public void save(Image image);
	
	public void delete(int imageId);
	
}
