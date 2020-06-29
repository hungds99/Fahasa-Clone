package com.hunter.dto;

import java.util.List;

import com.hunter.model.Category;

public class ProductCatalog {

	private Category category;
	private List<Category> parent_categories;
	private List<Category> children_categories;
	private List<ProductViewDTO> productList;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getParent_categories() {
		return parent_categories;
	}

	public void setParent_categories(List<Category> parent_categories) {
		this.parent_categories = parent_categories;
	}

	public List<Category> getChildren_categories() {
		return children_categories;
	}

	public void setChildren_categories(List<Category> children_categories) {
		this.children_categories = children_categories;
	}

	public List<ProductViewDTO> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductViewDTO> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "ProductCatalog [category=" + category + ", parent_categories=" + parent_categories
				+ ", children_categories=" + children_categories + ", productList=" + productList + "]";
	}
	
	

}
