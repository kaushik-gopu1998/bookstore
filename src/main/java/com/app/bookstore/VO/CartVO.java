package com.app.bookstore.VO;
import java.util.List;
public class CartVO {
 private List<CartItemVO> cartItems;
 private Float totalCost;
public CartVO(List<CartItemVO> cartItems, Float totalCost) {
	super();
	this.cartItems = cartItems;
	this.totalCost = totalCost;
}
public List<CartItemVO> getCartItems() {
	return cartItems;
}
public void setCartItems(List<CartItemVO> cartItems) {
	this.cartItems = cartItems;
}
public Float getTotalCost() {
	return totalCost;
}
public void setTotalCost(Float totalCost) {
	this.totalCost = totalCost;
}
@Override
public String toString() {
	return "CartVO [cartItems=" + cartItems + ", totalCost=" + totalCost + "]";
} 
}
