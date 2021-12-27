package com.app.bookstore.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = -3333773630498951676L;

	@Id
	private Integer categoryId;
	
	private String name;
	
	@OneToMany
	private Set<Products> product;

	public Category() {
		super();
	}
    
	public Category(Integer categoryId, String name, Set<Products> product) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.product = product;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public Set<Products> getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product.add(product);
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", product=" + product + "]";
	}

}
