package com.app.bookstore.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Shippers implements Serializable {

	private static final long serialVersionUID = 8981838706347692651L;

	@Id
	private Integer shipperId;
	
	private String shipperName;
	
	private String phoneNumber;
	
	@OneToOne
	private Orders order;

	public Shippers() {
		super();
	}

	public Shippers(Integer shipperId, String shipperName, String phoneNumber, Orders order) {
		super();
		this.shipperId = shipperId;
		this.shipperName = shipperName;
		this.phoneNumber = phoneNumber;
		this.order = order;
	}

	public Integer getShipperId() {
		return shipperId;
	}

	public void setShipperId(Integer shipperId) {
		this.shipperId = shipperId;
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Shippers [shipperId=" + shipperId + ", shipperName=" + shipperName + ", phoneNumber=" + phoneNumber
				+ ", order=" + order + "]";
	}
	
	
	
	

}
