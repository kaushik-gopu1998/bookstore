package com.app.bookstore.error;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.bookstore.exceptions.ApiError;
import com.app.bookstore.exceptions.CartItemNotExistsException;
import com.app.bookstore.exceptions.EmailIdExistsException;
import com.app.bookstore.exceptions.InvalidAddressIdException;
import com.app.bookstore.exceptions.InvalidInputException;
import com.app.bookstore.exceptions.ProductNotFoundException;
import com.app.bookstore.exceptions.ResponseEntityBuilder;
import com.app.bookstore.exceptions.UserIdNotFoundException;


@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler({EmailIdExistsException.class})
	public ResponseEntity<Object> handleForbiddenRequest(EmailIdExistsException ex , final WebRequest request){

		List<Object> details =  new ArrayList<Object>();
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
		List<Object> details =  new ArrayList<Object>();
		details.add(ex.getMessage());
		ApiError apiError = new ApiError(
				 LocalDateTime.now(),
				 HttpStatus.BAD_REQUEST,
				 "Invalid Input",
				 details
				);
		return ResponseEntityBuilder.build(apiError);
		
	}
	@ExceptionHandler({UserIdNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleConstraintViolation(UserIdNotFoundException ex , final WebRequest request){
		List<Object> details =  new ArrayList<Object>();
		details.add(ex.getMessage());
		ApiError apiError = new ApiError(
				 LocalDateTime.now(),
				 HttpStatus.NOT_FOUND,
				 "User Id Not Found!",
				 details
				);
		return ResponseEntityBuilder.build(apiError);		
}
	
	@ExceptionHandler({ProductNotFoundException.class})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleConstraintViolation(ProductNotFoundException ex , final WebRequest request){
		List<Object> details =  new ArrayList<Object>();
		details.add(ex.getMessage());
		ApiError apiError = new ApiError(
				 LocalDateTime.now(),
				 HttpStatus.NOT_FOUND,
				 "Product Not Found!",
				 details
				);
		return ResponseEntityBuilder.build(apiError);		
}

	
	
	
	
	@ExceptionHandler({InvalidInputException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleInvalidInputException(InvalidInputException ex, final WebRequest request){
		List<Object> details =  new ArrayList<Object>();
		details.add(ex.getList());
		ApiError apiError = new ApiError(
				 LocalDateTime.now(),
				 HttpStatus.BAD_REQUEST,
				 "Inavlid Input!",
			      details
				);
		return ResponseEntityBuilder.build(apiError);
	}
	
	@ExceptionHandler({InvalidAddressIdException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleInvalidInputException(InvalidAddressIdException ex, final WebRequest request){
		List<Object> details =  new ArrayList<Object>();
		details.add(ex.getMessage());
		ApiError apiError = new ApiError(
				 LocalDateTime.now(),
				 HttpStatus.BAD_REQUEST,
				 "Inavlid Input!",
			      details
				);
		return ResponseEntityBuilder.build(apiError);
	}
	
	
	@ExceptionHandler({CartItemNotExistsException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleInvalidInputException(CartItemNotExistsException ex, final WebRequest request){
		List<Object> details =  new ArrayList<Object>();
		details.add(ex.getMessage());
		ApiError apiError = new ApiError(
				 LocalDateTime.now(),
				 HttpStatus.BAD_REQUEST,
				 "Inavlid Input!",
			      details
				);
		return ResponseEntityBuilder.build(apiError);
	}
	

	/*
	 * why not @ExceptionHandler?
	 * handleMethodArgumentNotValid is also annotated to handle MethodArgumentNotValidException.
	 * So spring finds two methods that should be used to handle the same exception, that is the reason for the exception.
	 */
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex , HttpHeaders headers, HttpStatus status, final WebRequest request){
		List<Object> details = new ArrayList<Object>();
		details.add(ex.getFieldErrors());
		ApiError apiError = new ApiError(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST,
				"Invalid Entry!",
				details
				);
		return ResponseEntityBuilder.build(apiError);
	}
	
}
