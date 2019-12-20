package com.hunter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_attribute")
public class ProductAttribute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int attrCode;

	private String attrLanguage;

	private int attrAge;

	private String attrLayout;

	private int attrPage;
	
	private double attrWeight;

	private String attrSize;

	private int publishYear;

	private int authorId;

	private int publisherId;

	private int supplierId;
	
	private int productId;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAttrCode() {
		return attrCode;
	}

	public void setAttrCode(int attrCode) {
		this.attrCode = attrCode;
	}

	public String getAttrLanguage() {
		return attrLanguage;
	}

	public void setAttrLanguage(String attrLanguage) {
		this.attrLanguage = attrLanguage;
	}

	public int getAttrAge() {
		return attrAge;
	}

	public void setAttrAge(int attrAge) {
		this.attrAge = attrAge;
	}

	public String getAttrLayout() {
		return attrLayout;
	}

	public void setAttrLayout(String attrLayout) {
		this.attrLayout = attrLayout;
	}

	public int getAttrPage() {
		return attrPage;
	}

	public void setAttrPage(int attrPage) {
		this.attrPage = attrPage;
	}

	public double getAttrWeight() {
		return attrWeight;
	}

	public void setAttrWeight(double attrWeight) {
		this.attrWeight = attrWeight;
	}

	public String getAttrSize() {
		return attrSize;
	}

	public void setAttrSize(String attrSize) {
		this.attrSize = attrSize;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	@Override
	public String toString() {
		return "ProductAttribute [id=" + id + ", attrCode=" + attrCode + ", attrLanguage=" + attrLanguage + ", attrAge="
				+ attrAge + ", attrLayout=" + attrLayout + ", attrPage=" + attrPage + ", attrWeight=" + attrWeight
				+ ", attrSize=" + attrSize + ", publishYear=" + publishYear + ", authorId=" + authorId
				+ ", publisherId=" + publisherId + ", supplierId=" + supplierId + ", productId=" + productId + "]";
	}
	
	

}
