package com.app.bookstore.dto;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
@Entity

public class Products implements Serializable {

	private static final long serialVersionUID = -7440090907392499673L;

	@Id
	private Integer productId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String description;
	
	@Positive
	private float price;
    
	private boolean status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "supplier_id")
	private Users supplierId;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Positive
	private Integer unitsInStock;
	
	
	private Integer unitsOnSold;
	
	
	
	@OneToMany
	private Set<Reviews> review;
	
	@OneToMany
	private Set<Cart> cart;

	public Products() {
		super();
	}
	
	public Products(Integer productId, @NotNull String name, @NotNull String description, @Positive float price,
			boolean status, Users supplierId, Category category, @Positive Integer unitsInStock, Integer unitsOnSold,
			 Set<Reviews> review, Set<Cart> cart) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
		this.supplierId = supplierId;
		this.category = category;
		this.unitsInStock = unitsInStock;
		this.unitsOnSold = unitsOnSold;
			this.review = review;
		this.cart = cart;
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

	public Integer getUnitsOnSold() {
		return unitsOnSold;
	}

	public void setUnitsOnSold(Integer unitsOnOrder) {
		this.unitsOnSold = unitsOnOrder;
	}


	public Set<Reviews> getReview() {
		return review;
	}

	public void setReview(Reviews review) {
		this.review.add(review);
	}
	
	public Set<Cart> getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart.add(cart);
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", status=" + status + ", supplierId=" + supplierId + ", category=" + category
				+ ", unitsInStock=" + unitsInStock + ", unitsOnSold=" + unitsOnSold + ", review=" + review + ", cart="
				+ cart + "]";
	}
	
}
