package com.hunter.dto;

import java.util.List;

import com.hunter.model.Author;
import com.hunter.model.Category;
import com.hunter.model.Discount;
import com.hunter.model.Publisher;
import com.hunter.model.Supplier;

public class ProductAttributeDTO {

	private List<Category> categories;
	private List<Discount> discounts;
	private List<Author> authors;
	private List<Supplier> suppliers;
	private List<Publisher> publishers;

	public ProductAttributeDTO() {
		super();
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public List<Publisher> getPublishers() {
		return publishers;
	}

	public void setPublishers(List<Publisher> publishers) {
		this.publishers = publishers;
	}

}
