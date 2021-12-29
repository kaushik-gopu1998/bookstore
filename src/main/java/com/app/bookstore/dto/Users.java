package com.app.bookstore.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Users implements Serializable {
	

	private static final long serialVersionUID = 7555339944346726859L;

	@Id  
	private Integer userId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	int zip;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@OneToMany
	private Set<Products> product;
	
	@OneToMany
	private Set<Orders> order;
	
	@OneToMany
	private Set<Reviews> review;
	
	public Users() {
		super();
	}

	

	public Users(Integer userId, String firstName, String lastName, String email, String password, int zip, City city,
			Set<Products> product, Set<Orders> order, Set<Reviews> review) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.zip = zip;
		this.city = city;
		this.product = product;
		this.order = order;
		this.review = review;
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



	public int getZip() {
		return zip;
	}



	public void setZip(int zip) {
		this.zip = zip;
	}



	public City getCity() {
		return city;
	}



	public void setCity(City city) {
		this.city = city;
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



	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", zip=" + zip + ", city=" + city + ", product=" + product + ", order="
				+ order + ", review=" + review + "]";
	}
	
	
	



	
}
