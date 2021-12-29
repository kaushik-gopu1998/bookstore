package com.app.bookstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User Not Found")
public class UserIdNotFoundException extends Exception{

	private static final long serialVersionUID = 6806707843014938563L;
	
	public UserIdNotFoundException(String errorMessage)
	{
		super(errorMessage);
	}

}
