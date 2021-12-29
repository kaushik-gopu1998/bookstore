package com.app.bookstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "email already exists")
public class EmailIdExistsException extends Exception {
	private static final long serialVersionUID = -8216193048680907830L;
	
	public EmailIdExistsException(String errorMessage) {
		super(errorMessage);
	}

}
