package com.hunter.dto;

import java.io.Serializable;

public class ProductDTOs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8311949254959297779L;
	
	private int productID;
	private int productCode;
	private String productName;
	private double productPrice;
	private double productFinalprice;
	private int productAmount;
	private int productStatus;
	private String productContent;

	private String attrLanguage;
	private int attrAge;
	private String attrLayout;
	private int attrPage;
	private int attrPublishYear;
	private int attrSize;
	private double attrWeight;

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public double getProductFinalprice() {
		return productFinalprice;
	}

	public void setProductFinalprice(double productFinalprice) {
		this.productFinalprice = productFinalprice;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

	public int getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
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

	public int getAttrPublishYear() {
		return attrPublishYear;
	}

	public void setAttrPublishYear(int attrPublishYear) {
		this.attrPublishYear = attrPublishYear;
	}

	public int getAttrSize() {
		return attrSize;
	}

	public void setAttrSize(int attrSize) {
		this.attrSize = attrSize;
	}

	public double getAttrWeight() {
		return attrWeight;
	}

	public void setAttrWeight(double attrWeight) {
		this.attrWeight = attrWeight;
	}

	@Override
	public String toString() {
		return "ProductDTO [productID=" + productID + ", productCode=" + productCode + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", productFinalprice=" + productFinalprice + ", productAmount="
				+ productAmount + ", productStatus=" + productStatus + ", productContent=" + productContent
				+ ", attrLanguage=" + attrLanguage + ", attrAge=" + attrAge + ", attrLayout=" + attrLayout
				+ ", attrPage=" + attrPage + ", attrPublishYear=" + attrPublishYear + ", attrSize=" + attrSize
				+ ", attrWeight=" + attrWeight + "]";
	}

	
}
