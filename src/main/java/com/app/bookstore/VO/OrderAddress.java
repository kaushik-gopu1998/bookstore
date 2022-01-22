package com.app.bookstore.VO;

public class OrderAddress {	
	private String address;
	private String street;
	private String city;
	private Integer pinCode;
	private String state;
	public OrderAddress(String address, String street, String city, Integer pinCode, String state) {
		super();
		this.address = address;
		this.street = street;
		this.city = city;
		this.pinCode = pinCode;
		this.state = state;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPinCode() {
		return pinCode;
	}
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "OrderAddress [address=" + address + ", street=" + street + ", city=" + city + ", pinCode=" + pinCode
				+ ", state=" + state + "]";
	}
}
