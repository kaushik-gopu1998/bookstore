package com.app.bookstore.error;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.bookstore.exceptions.ApiError;
import com.app.bookstore.exceptions.EmailIdExistsException;
import com.app.bookstore.exceptions.ResponseEntityBuilder;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler({EmailIdExistsException.class})
	public ResponseEntity<Object> handleForbiddenRequest(EmailIdExistsException ex , final WebRequest request){

		List<String> details =  new ArrayList<String>();
		details.add(ex.getMessage());
		ApiError apiError = new ApiError(
				 LocalDateTime.now(),
				 HttpStatus.FORBIDDEN,
				 "EmailId Exists!",
				 details
				);
		return ResponseEntityBuilder.build(apiError);
		
	}
	
	@ExceptionHandler({ConstraintViolationException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex , final WebRequest request){
		List<String> details =  new ArrayList<String>();
		details.add(ex.getMessage());
		ApiError apiError = new ApiError(
				 LocalDateTime.now(),
				 HttpStatus.BAD_REQUEST,
				 "Invalid Input",
				 details
				);
		return ResponseEntityBuilder.build(apiError);
		
	}	
}
