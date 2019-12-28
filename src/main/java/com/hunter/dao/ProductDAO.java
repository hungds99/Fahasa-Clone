package com.hunter.dao;

import java.util.List;

import com.hunter.dto.SearchDTO;

public interface ProductDAO {

	List<Object []> getProductBySearch(SearchDTO searchDTO);
	
	List<Object[]> getProductByCategoryId(int categoryId);
	
}
