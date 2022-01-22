package com.app.bookstore.VO;

public class AddToCartVO {
  private Integer productId;
  private Integer quantity;
  public AddToCartVO() {
	super();
  }

public Integer getProductId() {
	return productId;
}
public void setProductId(Integer productId) {
	this.productId = productId;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "AddToCartVO [productId=" + productId + ", quantity=" + quantity + "]";
}
  
  
  
  
}
