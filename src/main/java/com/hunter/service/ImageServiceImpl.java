package com.hunter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunter.model.Image;
import com.hunter.repository.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	ImageRepository imageRepository;

	@Override
	public List<Image> findByProductId(int productId) {
		return imageRepository.findByProductId(productId);
	}

	@Override
	public void save(Image image) {
		imageRepository.save(image);

	}

	@Override
	public void delete(int imageId) {
		imageRepository.deleteById(imageId);
	}

}
