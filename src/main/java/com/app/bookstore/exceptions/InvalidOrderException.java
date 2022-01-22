package com.app.bookstore.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Invalid Input")
public class InvalidOrderException extends Exception {

	private static final long serialVersionUID = 1454790414132116407L;
	 private List<String> list;	


		public InvalidOrderException(List<String> errors) {
		super();	
		this.list=errors;
		}


		public List<String> getList() {
			return list;
		}


		public void setList(List<String> list) {
			this.list = list;
		}
		
}
