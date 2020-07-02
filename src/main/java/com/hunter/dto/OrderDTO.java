package com.hunter.dto;

import java.util.List;

public class OrderDTO {

	private int orderId;
	private String orderDate;
	private String orderStatus;
	private List<OrderProductDTO> orderProduct;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<OrderProductDTO> getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(List<OrderProductDTO> orderProduct) {
		this.orderProduct = orderProduct;
	}

	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", orderProduct=" + orderProduct + "]";
	}

}
