package com.app.bookstore.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.bookstore.dto.Users;

public class UserDetailsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Users.class.equals(clazz);
	}

	@Override
	public void validate(Object user, Errors errors) {
		
	}

}
