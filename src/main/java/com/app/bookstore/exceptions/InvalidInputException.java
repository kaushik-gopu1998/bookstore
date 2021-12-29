package com.app.bookstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid Input")
public class InvalidInputException extends Exception{

	private static final long serialVersionUID = 792143501836367977L;
	
	public InvalidInputException(String errorMessage) {
		super(errorMessage);
	}

}
