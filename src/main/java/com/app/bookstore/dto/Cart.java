package com.app.bookstore.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Cart {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer Id;
	
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Products product;
	
	@OneToOne
	@JoinColumn(name ="user_id")
	private Users userId;
	
	private Integer quantity;

	public Cart() {
		super();
	}

	public Cart( Date createdDate, Products product, Users userId, Integer quantity) {
		super();
		this.createdDate = createdDate;
		this.product = product;
		this.userId = userId;
		this.quantity = quantity;
	}

	public Integer getCartId() {
		return Id;
	}

	public void setCartId(Integer cartId) {
		this.Id = cartId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public Users getUser() {
		return userId;
	}

	public void setUser(Users userId) {
		this.userId = userId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + Id + ", createdDate=" + createdDate + ", product=" + product + ", user=" + userId
				+ ", quantity=" + quantity + "]";
	}
	
	
}
