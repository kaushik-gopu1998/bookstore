package com.app.bookstore.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.bookstore.dto.Orders;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class OrderDetailsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {   
	
	}	
	
}
