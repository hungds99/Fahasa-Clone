package com.hunter.dao;

public interface CategoryDAO {

	String findCategoryBreadcrumbByParentId(int parentId);
	
}
