package com.hunter.dto;

public class ProductViewDTO {

	private int productId;
	private String productName;
	private double productPrice;
	private int promotionValue;
	private double productFinalprice;
	private String imageUrl;
	private String imageAlt;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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

	public int getPromotionValue() {
		return promotionValue;
	}

	public void setPromotionValue(int promotionValue) {
		this.promotionValue = promotionValue;
	}

	public double getProductFinalprice() {
		return productFinalprice;
	}

	public void setProductFinalprice(double productFinalprice) {
		this.productFinalprice = productFinalprice;
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

}
