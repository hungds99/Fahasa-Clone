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
	private int discountValue;
	private int amount;
	private Date createDate;
	private String productStatus;
	
	public String getImageAlt() {
		return imageAlt;
	}

	public void setImageAlt(String imageAlt) {
		this.imageAlt = imageAlt;
	}

	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public boolean getHighlight() {
		return highlight;
	}

	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}

	public boolean getIsshowed() {
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

	public int getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(int discountValue) {
		this.discountValue = discountValue;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productCode=" + productCode + ", categoryName=" + categoryName
				+ ", productName=" + productName + ", imageUrl=" + imageUrl + ", imageAlt=" + imageAlt + ", highlight="
				+ highlight + ", isshowed=" + isshowed + ", price=" + price + ", finalPrice=" + finalPrice
				+ ", discountValue=" + discountValue + ", amount=" + amount + ", createDate=" + createDate
				+ ", productStatus=" + productStatus + "]";
	}
	
	

}
