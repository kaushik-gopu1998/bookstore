package com.app.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.app.bookstore.dto.Users;
import com.app.bookstore.exceptions.InvalidInputException;
import com.app.bookstore.validators.UserDetailsValidator;

@Service
public class UsersService {
	@Autowired
	UserDetailsValidator userDetailsValidator;
	public void performUserDataValidation(Users user, BindingResult result) throws InvalidInputException {
		userDetailsValidator.validate(user, result);
		if(result.hasErrors())
		{
			List<String> errors = new ArrayList<>();
		    for(ObjectError error : result.getAllErrors()) {
		    	errors.add(((FieldError) error).getField());
		    }
			throw new InvalidInputException(errors);
		}						
	}	
}
