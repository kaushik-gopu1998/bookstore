package com.app.bookstore.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Orders implements Serializable {

	private static final long serialVersionUID = -7006005479515401167L;

	@Id
	private Integer orderId;
	
	private Date orderDate;
	
	private Date orderSentDate;
	
	private String address;
	
	private String street;
	
	private Integer pinCode;
	
	private Float totalAmount;
	
	@OneToOne
	@JoinColumn(name="status_id")
	private OrderStatus statusId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users userId;
	
	@OneToOne
	@JoinColumn(name = "shipper_id")
	private Shippers shipperId;
	
	@OneToMany
	private Set<OrderLines> orderLines;

	public Orders() {
		super();
	}

	public Orders(Integer orderId, Date orderDate, Date orderSentDate, String address, String street, Integer pinCode,
			Float totalAmount, OrderStatus statusId, Users userId, Shippers shipperId, Set<OrderLines> orderLines) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderSentDate = orderSentDate;
		this.address = address;
		this.street = street;
		this.pinCode = pinCode;
		this.totalAmount = totalAmount;
		this.statusId = statusId;
		this.userId = userId;
		this.shipperId = shipperId;
		this.orderLines = orderLines;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getOrderSentDate() {
		return orderSentDate;
	}

	public void setOrderSentDate(Date orderSentDate) {
		this.orderSentDate = orderSentDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public Float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public OrderStatus getStatusId() {
		return statusId;
	}

	public void setStatusId(OrderStatus statusId) {
		this.statusId = statusId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public Shippers getShipperId() {
		return shipperId;
	}

	public void setShipperId(Shippers shipperId) {
		this.shipperId = shipperId;
	}

	public Set<OrderLines> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(OrderLines orderLines) {
		this.orderLines.add(orderLines);
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", orderSentDate=" + orderSentDate
				+ ", address=" + address + ", street=" + street + ", pinCode=" + pinCode + ", totalAmount="
				+ totalAmount + ", statusId=" + statusId + ", userId=" + userId + ", shipperId=" + shipperId
				+ ", orderLines=" + orderLines + "]";
	}
}
