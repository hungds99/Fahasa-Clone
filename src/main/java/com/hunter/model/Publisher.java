package com.hunter.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "publisher")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String publisherName;
	
	private String publisherInfo;

	private String publisherImage;
	
	@OneToMany
	@JsonIgnore
	private List<ProductAttribute> productAttributes;
	
	public String getPublisherInfo() {
		return publisherInfo;
	}

	public void setPublisherInfo(String publisherInfo) {
		this.publisherInfo = publisherInfo;
	}

	public List<ProductAttribute> getProductAttributes() {
		return productAttributes;
	}

	public void setProductAttributes(List<ProductAttribute> productAttributes) {
		this.productAttributes = productAttributes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherImage() {
		return publisherImage;
	}

	public void setPublisherImage(String publisherImage) {
		this.publisherImage = publisherImage;
	}

}
