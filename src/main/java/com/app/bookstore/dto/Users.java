package com.app.bookstore.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Users implements Serializable {
	

	private static final long serialVersionUID = 7555339944346726859L;

	@Id  
	private Integer userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String phoneNumber;
    
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL)
	private Set<UserAddress> userAddress;
	
	@OneToMany(mappedBy="supplierId")
	private Set<Products> product;
	
	@OneToMany(mappedBy="userId")
	private Set<Orders> order;
	
	@OneToMany
	private Set<Reviews> review;
	
	
	public Users() {
		super();
	}

	






	public Users(Integer userId, String firstName, String lastName, String email, String password, String phoneNumber,
			Set<Products> product, Set<Orders> order, Set<Reviews> review, Set<UserAddress> userAddress) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.product = product;
		this.order = order;
		this.review = review;
		this.userAddress = userAddress;
	}








	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

   
	public Set<Products> getProduct() {
		return product;
	}



	public void setProduct(Products product) {
		this.product.add(product);
	}


	
	public Set<Orders> getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order.add(order);
	}

	public Set<Reviews> getReview() {
		return review;
	}

	public void setReview(Reviews review) {
		this.review.add(review);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<UserAddress> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(UserAddress userAddress) {
		this.userAddress.add(userAddress);
	}






	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phoneNumber=" + phoneNumber + ", product=" + product + ", order="
				+ order + ", review=" + review + ", userAddress=" + userAddress + "]";
	}
	
	

   


}
