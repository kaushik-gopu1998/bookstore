package com.app.bookstore.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class OrderStatus implements Serializable {

	private static final long serialVersionUID = 4204928252555852808L;

	@Id
	private Integer id;
	
	private String name;
	
	@OneToOne
	private Orders order;

	public OrderStatus() {
		super();
	}

	public OrderStatus(Integer id, String name, Orders order) {
		super();
		this.id = id;
		this.name = name;
		this.order = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderStatus [id=" + id + ", name=" + name + ", order=" + order + "]";
	}
	
	
	
}
