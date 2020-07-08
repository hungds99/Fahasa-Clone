package com.hunter.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Vui lòng điền họ tên")
	private String name;
	
	@NotEmpty(message = "Vui lòng điền địa chỉ")
	private String address;
	
	private String gender;
	
	private Date birthday;
	
	@NotNull(message = "Vui lòng điền số điện thoại")
	private Integer phone;
	
	@NotEmpty(message = "Vui lòng điền địa chỉ email")
	private String email;
	
	private String username;
	
	private String password;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Comment> comments;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<OrderCustomer> orders;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<OrderCustomer> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderCustomer> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", gender=" + gender + ", birthday="
				+ birthday + ", phone=" + phone + ", email=" + email + ", username=" + username + ", password="
				+ password + ", comments=" + comments + ", orders=" + orders + "]";
	}
	
	
	
}
