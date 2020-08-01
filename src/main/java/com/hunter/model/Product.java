package com.hunter.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4249393962848657120L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String productName;

	private Double productPrice;

	private double productFinalprice;

	private Integer productCode;

	private int productStatus;
	
	private Integer productAmount;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private boolean highlight;

	private boolean isshowed;

	private String productContent;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "discount_id")
	private Discount discount;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "promotion_id")
	private Promotion promotion;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Set<Comment> comments;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Set<OrderDetail> orderDetails;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private Set<Image> images;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public double getProductFinalprice() {
		return productFinalprice;
	}

	public void setProductFinalprice(double productFinalprice) {
		this.productFinalprice = productFinalprice;
	}	

	public int getProductStatus() {
		return productStatus;
	}

	public Integer getProductCode() {
		return productCode;
	}

	public void setProductCode(Integer productCode) {
		this.productCode = productCode;
	}

	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
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

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productFinalprice=" + productFinalprice + ", productCode=" + productCode + ", productStatus="
				+ productStatus + ", productAmount=" + productAmount + ", createdDate=" + createdDate + ", highlight="
				+ highlight + ", isshowed=" + isshowed + ", productContent=" + productContent + ", category=" + category
				+ ", discount=" + discount + ", comments=" + comments + ", orderDetails=" + orderDetails + ", images="
				+ images + "]";
	}

}
