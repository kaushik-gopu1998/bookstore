package com.app.bookstore.VO;

public class CartQuantityUpdateVO {
	Integer cartItemId;
	Integer quantity;
	public Integer getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartQuantityUpdateVO [cartItemId=" + cartItemId + ", quantity=" + quantity + "]";
	}
	

}
