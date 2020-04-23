package com.hunter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hunter.dao.ProductDAO;
import com.hunter.dto.ProductDTO;
import com.hunter.dto.ProductViewDTO;
import com.hunter.dto.SearchDTO;
import com.hunter.model.Image;
import com.hunter.model.Product;
import com.hunter.repository.CategoryRepository;
import com.hunter.repository.ProductRepository;
import com.hunter.utils.ConstantUtil;
import com.hunter.utils.DateUtil;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ProductDAO productDAO;

	@Override
	public Product findProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public List<ProductDTO> getProductBySearch(SearchDTO searchDTO) {
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		List<Object[]> results = productDAO.getProductBySearch(searchDTO);
		if (results != null && !results.isEmpty()) {
			for (Object[] object : results) {

				ProductDTO product = new ProductDTO();

				product.setProductId(Integer.parseInt(convertString(object[0])));
				product.setProductCode(Integer.parseInt(convertString(object[1])));
				product.setCategoryName(convertString(object[2]));
				product.setProductName(convertString(object[3]));
				product.setImageUrl(object[4] == null ? null : object[4].toString());
				product.setImageAlt(object[5] == null ? null : object[5].toString());
				product.setHighlight(object[6].toString().equals("true") ? true : false);
				product.setIsshowed(object[7].toString().equals("true") ? true : false);
				product.setPrice(Double.parseDouble(convertString(object[8])));
				product.setFinalPrice(
						Double.parseDouble(convertString(object[8])) * Integer.parseInt(convertString(object[9])));
				product.setPromotionValue(Integer.parseInt(convertString(object[9])));
				product.setCreateDate(object[10].toString());
				product.setAmount(Integer.parseInt(convertString(object[11])));
				switch (Integer.parseInt(convertString(object[12]))) {
				case 1:
					product.setProductStatus(ConstantUtil.ProductStatus.CONHANG.getValue());
					break;
				case 2:
					product.setProductStatus(ConstantUtil.ProductStatus.HETHANG.getValue());
					break;
				default:
					product.setProductStatus(ConstantUtil.ProductStatus.SAPMOBAN.getValue());
					break;
				}

				products.add(product);
			}
		}
		return products;
	}

	public String convertString(Object obj) {
		if (obj.equals(null)) {
			return "0";
		} else {
			return obj.toString();
		}
	}

	@Override
	public Product saveAndUpdate(Product product) {
		Product productExist = productRepository.findById(product.getId()).orElse(null);
		if (productExist != null) {

			productExist.setProductCode(product.getProductCode());
//			productExist.setCategory(categoryRepository.findById(product.getCategory().getId()).orElse(null));
			productExist.setCategory(product.getCategory());
			productExist.setProductName(product.getProductName());
			productExist.setProductPrice(product.getProductPrice());
			productExist.setProductAmount(product.getProductAmount());
			productExist.setCreatedDate(DateUtil.getCurrentDateTime());
			productExist.setDiscount(product.getDiscount());
			productExist.setProductStatus(product.getProductStatus());
			productExist.setHighlight(product.isHighlight());
			productExist.setIsshowed(product.isIsshowed());
			productExist.setProductContent(product.getProductContent());

			Product p = productRepository.save(productExist);
			return p;
		}
		product.setCreatedDate(DateUtil.getCurrentDateTime());
		Product p = productRepository.save(product);
		return p;

	}

	@Override
	public List<ProductViewDTO> getProductByCategoryId(int categoryId) {

		List<Object[]> results = productDAO.getProductByCategoryId(categoryId);

		List<ProductViewDTO> productViewDTOs = this.convertToProductView(results);

		return productViewDTOs;
	}

	@Override
	public ProductViewDTO getProductByProductId(int productId) {
		List<Object[]> results = productDAO.getProductByProductId(productId);

		List<ProductViewDTO> productViewDTOs = this.convertToProductView(results);

		return productViewDTOs.get(0);
	}

	// Convert Object Select Query to Model
	public List<ProductViewDTO> convertToProductView(List<Object[]> results) {
		List<ProductViewDTO> productViewDTOs = new ArrayList<ProductViewDTO>();

		if (results != null && !results.isEmpty()) {

			for (Object[] obj : results) {
				ProductViewDTO product = new ProductViewDTO();

				product.setProductId(Integer.parseInt(obj[0].toString()));
				product.setProductName(obj[1].toString());
				product.setProductPrice(Double.parseDouble(obj[2].toString()));
				product.setPromotionValue(Integer.parseInt(obj[3].toString()));
				product.setImageUrl(obj[4].toString());
				product.setImageAlt(obj[5].toString());
				product.setProductFinalprice(
						(Double.parseDouble(obj[2].toString()) * Integer.parseInt(obj[3].toString())) / 100);

				productViewDTOs.add(product);
			}
		}
		return productViewDTOs;
	}

	@Override
	public Product getProductWithImage(int productId) {
		Product product = this.findProductById(productId);
		Set<Image> images = product.getImages();
		
		return null;
	}

}
