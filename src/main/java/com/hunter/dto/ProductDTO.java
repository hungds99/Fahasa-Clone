package com.hunter.dto;

import java.util.Date;

public class ProductDTO {

	private int productId;
	private int productCode;
	private String categoryName;
	private String productName;
	private String imageUrl;
	private String imageAlt;
	private boolean highlight;
	private boolean isshowed;
	private double price;
	private double finalPrice;
	private int promotionValue;
	private int amount;
	private String createDate;
	private String productStatus;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageAlt() {
		return imageAlt;
	}
	public void setImageAlt(String imageAlt) {
		this.imageAlt = imageAlt;
	}
	public boolean isHighlight() {
		return highlight;
	}
	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}
	public boolean isIsshowed() {
		return isshowed;
	}
	public void setIsshowed(boolean isshowed) {
		this.isshowed = isshowed;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	public int getPromotionValue() {
		return promotionValue;
	}
	public void setPromotionValue(int promotionValue) {
		this.promotionValue = promotionValue;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	
}
