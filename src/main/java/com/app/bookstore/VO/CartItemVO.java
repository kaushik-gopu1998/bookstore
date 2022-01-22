package com.app.bookstore.VO;

public class CartItemVO {
  private Integer id;
  private Integer quantity;
  private ProductsVO product;
public CartItemVO(Integer id, Integer quantity, ProductsVO product ) {
	super();
	this.id = id;
	this.quantity = quantity;
	this.product = product;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public ProductsVO getProduct() {
	return product;
}
public void setProduct(ProductsVO product) {
	this.product = product;
}
@Override
public String toString() {
	return "CartItemVO [id=" + id + ", quantity=" + quantity + ", product=" + product + "]";
}  
}
