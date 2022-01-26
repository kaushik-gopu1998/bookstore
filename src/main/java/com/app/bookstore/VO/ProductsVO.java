package com.app.bookstore.VO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.app.bookstore.dto.Category;

public class ProductsVO {

	private Integer productId;
	@NotNull
	@Size(min = 3, max = 20)
	private String name;
	@NotNull
	@Size(min = 20)
	private String description;
	@Positive
	private Float price;
	private boolean status;
	private Category category;
	@Positive
	private Integer unitsInStock;
	private Integer unitsOnSold;
	public ProductsVO() {
		super();
	}
	
	public ProductsVO(Integer productId, String name, String description, Float price, boolean status,
			Category category, Integer unitsInStock, Integer unitsOnSold) {
		super();
		this.productId=productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.status = status;
		this.category = category;
		this.unitsInStock = unitsInStock;
		this.unitsOnSold = unitsOnSold;
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
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
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
	public void setUnitsOnSold(Integer unitsOnSold) {
		this.unitsOnSold = unitsOnSold;
	}

	@Override
	public String toString() {
		return "ProductsVO [productId=" + productId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", status=" + status + ", category=" + category + ", unitsInStock=" + unitsInStock
				+ ", unitsOnSold=" + unitsOnSold + "]";
	}
	
	
	
}
