package com.hunter.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "author")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String authorName;
	
	private int authorAge;
	
	private String authorInfo;
	
	private String authorImage;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ProductAttribute> productAttribute;

	public List<ProductAttribute> getProductAttribute() {
		return productAttribute;
	}

	public void setProductAttribute(List<ProductAttribute> productAttribute) {
		this.productAttribute = productAttribute;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getAuthorAge() {
		return authorAge;
	}

	public void setAuthorAge(int authorAge) {
		this.authorAge = authorAge;
	}

	public String getAuthorInfo() {
		return authorInfo;
	}

	public void setAuthorInfo(String authorInfo) {
		this.authorInfo = authorInfo;
	}

	public String getAuthorImage() {
		return authorImage;
	}

	public void setAuthorImage(String authorImage) {
		this.authorImage = authorImage;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", authorName=" + authorName + ", authorAge=" + authorAge + ", authorInfo="
				+ authorInfo + ", authorImage=" + authorImage + "]";
	}

}
