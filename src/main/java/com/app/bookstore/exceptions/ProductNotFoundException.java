package com.app.bookstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Product Not Found")
public class ProductNotFoundException extends Exception {
 	private static final long serialVersionUID = -599853039646221004L;

public ProductNotFoundException(String errorMessage) {
	  super(errorMessage);
  }
}
