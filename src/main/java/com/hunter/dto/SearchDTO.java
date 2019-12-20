package com.hunter.dto;

import java.sql.Date;

public class SearchDTO {

	private int category;
	private int price;
	private int amount;
	private int status;
	private int highlight;
	private int isshowed;
	private Date fromDate;
	private Date toDate;
	private int records;
	private String keyword;
	private int currentPage;

	@Override
	public String toString() {
		return "SearchDTO [category=" + category + ", price=" + price + ", amount=" + amount + ", status=" + status
				+ ", highlight=" + highlight + ", isshowed=" + isshowed + ", fromDate=" + fromDate + ", toDate="
				+ toDate + ", records=" + records + ", keyword=" + keyword + ", currentPage=" + currentPage + "]";
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getHighlight() {
		return highlight;
	}

	public void setHighlight(int highlight) {
		this.highlight = highlight;
	}

	public int getIsshowed() {
		return isshowed;
	}

	public void setIsshowed(int isshowed) {
		this.isshowed = isshowed;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

}
