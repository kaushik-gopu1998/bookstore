package com.app.bookstore.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Products implements Serializable {

	private static final long serialVersionUID = -7440090907392499673L;

	@Id
	private Integer productId;
	
	private String name;
	
	private String description;
	
	private float price;
    
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private Users supplierId;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	private Integer unitsInStock;
	
	private Integer unitsOnOrder;
	
	@OneToMany
	private Set<OrderLines> orderLine;
	
	@OneToMany
	private Set<Reviews> review;

	public Products() {
		super();
	}
	
	
	public Products(Integer productId, String name, String description, float price, boolean status, Users supplierId,
			Category category, Integer unitsInStock, Integer unitsOnOrder, Set<OrderLines> orderLine,
			Set<Reviews> review) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
		this.supplierId = supplierId;
		this.category = category;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.orderLine = orderLine;
		this.review = review;
	}


	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Users getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Users supplierId) {
		this.supplierId = supplierId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(Integer unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public Integer getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public void setUnitsOnOrder(Integer unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}
	
	
	public Set<OrderLines> getOrderLine() {
		return orderLine;
	}


	public void setOrderLine(OrderLines orderLine) {
		this.orderLine.add(orderLine);
	}


	public Set<Reviews> getReview() {
		return review;
	}


	public void setReview(Reviews review) {
		this.review.add(review);
	}


	@Override
	public String toString() {
		return "Products [productId=" + productId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", status=" + status + ", supplierId=" + supplierId + ", category=" + category
				+ ", unitsInStock=" + unitsInStock + ", unitsOnOrder=" + unitsOnOrder + ", orderLine=" + orderLine
				+ ", review=" + review + "]";
	}


		

}
