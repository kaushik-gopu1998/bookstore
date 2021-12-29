package com.app.bookstore.dto;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class OrderLines  implements Serializable{

	private static final long serialVersionUID = 7949787868201340973L;

	@Id
	private Integer lineId;
	
	@ManyToOne
	@JoinColumn(name ="product_id")
	private Products prodcut;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Orders order;
	
	private Float price;
	
	private Date orderDate;
	
	private Integer quantity;

	public OrderLines() {
		super();
	}

	public OrderLines(Integer lineId, Products prodcut, Orders order, Float price, Date orderDate, Integer quantity) {
		super();
		this.lineId = lineId;
		this.prodcut = prodcut;
		this.order = order;
		this.price = price;
		this.orderDate = orderDate;
		this.quantity = quantity;
	}

	public Integer getLineId() {
		return lineId;
	}

	public void setLineId(Integer lineId) {
		this.lineId = lineId;
	}

	public Products getProdcut() {
		return prodcut;
	}

	public void setProdcut(Products prodcut) {
		this.prodcut = prodcut;
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

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderLines [lineId=" + lineId + ", prodcut=" + prodcut + ", order=" + order + ", price=" + price
				+ ", orderDate=" + orderDate + ", quantity=" + quantity + "]";
	}
		
}
