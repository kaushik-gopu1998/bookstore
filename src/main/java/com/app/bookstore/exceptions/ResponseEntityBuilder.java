package com.app.bookstore.exceptions;

import org.springframework.http.ResponseEntity;

import com.app.bookstore.exceptions.ApiError;

public class ResponseEntityBuilder {
	
	public static ResponseEntity<Object> build(ApiError apiError) {
	      return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}