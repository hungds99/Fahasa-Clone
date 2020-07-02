package com.hunter.dto;

public class OrderProductDTO {
	private String orderProduct;
	private Double orderPrice;
	private int orderAmount;

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
