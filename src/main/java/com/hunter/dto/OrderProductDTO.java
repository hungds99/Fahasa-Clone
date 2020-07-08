package com.hunter.dto;

public class OrderProductDTO {
	private String orderProduct;
	private Double orderPrice;
	private int orderAmount;
	private Double orderPriceTotal;
	private String productName;
	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getOrderPriceTotal() {
		return orderPriceTotal;
	}

	public void setOrderPriceTotal(Double orderPriceTotal) {
		this.orderPriceTotal = this.orderPrice*this.orderAmount;
	}

	public String getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(String orderProduct) {
		this.orderProduct = orderProduct;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	@Override
	public String toString() {
		return "OrderProductDTO [orderProduct=" + orderProduct + ", orderPrice=" + orderPrice + ", orderAmount="
				+ orderAmount + "]";
	}

}
