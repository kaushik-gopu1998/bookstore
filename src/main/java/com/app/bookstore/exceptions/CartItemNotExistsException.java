package com.app.bookstore.exceptions;

public class CartItemNotExistsException extends Exception {

	private static final long serialVersionUID = -4495607340855675091L;
	public CartItemNotExistsException(String errorMessage) {
		super(errorMessage);
	}

}
