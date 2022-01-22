package com.app.bookstore.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class OrderLines  implements Serializable{

	private static final long serialVersionUID = 7949787868201340973L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer lineId;
	
	@OneToOne
	@JoinColumn(name ="product_id")
	@NotNull
	private Products prodcutId;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Orders order;
		
	private Float price;
	
	private Integer quantity;

	public OrderLines() {
		super();
	}

	public OrderLines(Integer lineId, Products prodcutId, Orders order, Float price, Integer quantity) {
		super();
		this.lineId = lineId;
		this.prodcutId = prodcutId;
		this.order = order;
		this.price = price;
		this.quantity = quantity;
	}

	public Integer getLineId() {
		return lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}
	
	public Products getProdcutId() {
		return prodcutId;
	}

	public void setProdcutId(Products prodcutId) {
		this.prodcutId = prodcutId;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderLines [lineId=" + lineId + ", prodcutId=" + prodcutId + ", order=" + order + ", price=" + price
				 + ", quantity=" + quantity + "]";
	}
		
}
