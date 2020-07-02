package com.hunter.dao;

import java.util.List;

import com.hunter.dto.SearchDTO;

public interface ProductDAO {

	List<Object []> getProductBySearch(SearchDTO searchDTO);
	
	List<Object[]> getProductByCategoryId(int categoryId);
	
	List<Object []> getProductByProductId(int productId);
	
	List<Object []> getProductByOrder(int categoryId, int productStatus, boolean highlight, boolean promotion);
	
	List<Object[]> getProductByCategoryIdSort(int categoryId, String sortBy);
	
	List<Object[]> getProductByOrder(int category_id, String order_by, int page, int limit);
	
	List<Object[]> getProductBySearch(String terms, String order_by, int page, int limit);
	
}
