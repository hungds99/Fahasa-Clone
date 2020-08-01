package com.hunter.model;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name = "promotion")
public class Promotion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1301104835142042783L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String promotionName;

	private String promotionValue;

	private String promotionType;

	private Date createdDate;

	private Date beginDate;

	private Date endDate;

	private String promotionRule;

	private boolean usedValid;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion")
	@JsonIgnore
	private List<Product> products;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion")
	@JsonIgnore
	private List<Image> images;

	public boolean isUsedValid() {
		return usedValid;
	}

	public void setUsedValid(boolean usedValid) {
		this.usedValid = usedValid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getPromotionValue() {
		return promotionValue;
	}

	public void setPromotionValue(String promotionValue) {
		this.promotionValue = promotionValue;
	}

	public String getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPromotionRule() {
		return promotionRule;
	}

	public void setPromotionRule(String promotionRule) {
		this.promotionRule = promotionRule;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

}
