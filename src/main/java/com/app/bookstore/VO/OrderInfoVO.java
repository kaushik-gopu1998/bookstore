package com.app.bookstore.VO;

public class OrderInfoVO {
Integer userId;
Integer addressId;
public OrderInfoVO() {
	super();
}
public OrderInfoVO(Integer userId, Integer addressId) {
	super();
	this.userId = userId;
	this.addressId = addressId;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public Integer getAddressId() {
	return addressId;
}
public void setAddressId(Integer addressId) {
	this.addressId = addressId;
}
@Override
public String toString() {
	return "OrderInfoVO [userId=" + userId + ", addressId=" + addressId + "]";
}

}
