package com.hunter.service;

import java.util.List;

import com.hunter.dto.ProductCatalog;
import com.hunter.dto.ProductDTO;
import com.hunter.dto.ProductViewDTO;
import com.hunter.dto.SearchDTO;
import com.hunter.model.Product;

public interface ProductService {

	public Product findProductById(int id);

	public List<ProductDTO> getProductBySearch(SearchDTO searchDTO);

	public Product saveAndUpdate(Product product);

	public List<ProductViewDTO> getProductByCategoryId(int categoryId);

	public ProductViewDTO getProductByProductId(int productId);

	public Product getProductWithImage(int productId);

	public ProductCatalog getProductCatalog(int categoryId);

	public List<ProductViewDTO> getProductByCategoryIdSort(int categoryId, String sortBy);

	public List<ProductViewDTO> getProductByOrder(int category_id, String order_by, int page, int limit);
	
	public List<ProductViewDTO> getProductBySearch(String terms, String order_by, int page, int limit);

}
