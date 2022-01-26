package com.app.bookstore.exceptions;

public class QuantityOverFlowException extends Exception {

	private static final long serialVersionUID = -7726769087249015190L;
	public QuantityOverFlowException(String errorMessage) {
		super(errorMessage);
	}

}
