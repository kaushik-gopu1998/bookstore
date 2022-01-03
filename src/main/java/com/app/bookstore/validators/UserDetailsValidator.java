package com.app.bookstore.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.bookstore.dto.Users;

@Component
public class UserDetailsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Users.class.equals(clazz);
	}

	@Override
	public void validate(Object userObj, Errors errors) {
		Users user = (Users) userObj;
		if (checkInputString(user.getFirstName())) {
            errors.rejectValue("firstname", "firstname.invalid");
        }
		
		if(checkInputString(user.getLastName())) {
			 errors.rejectValue("lastname", "lastnamename.ivalid");
		}
		
		if(checkInputString(user.getPassword()) || !checkPasswordStrngth(user.getPassword())) {
			errors.rejectValue("password", "password.invalid");
		}
			  
        if(checkInputString(user.getEmail()) || !checkEmailValidOrNot(user.getEmail())) {
            errors.rejectValue("email", "email.invalid");
        }
        
        if(checkInputString(user.getPhoneNumber()) || !checkPhoneNumberValidOrNot(user.getPhoneNumber())) {
        	errors.rejectValue("phoneNumber", "phonenumber.invalid");
        }
        
       
	}
	/*
	 * (?=.*[0-9]) a digit must occur at least once
       (?=.*[a-z]) a lower case letter must occur at least once
       (?=.*[A-Z]) an upper case letter must occur at least once
       (?=.*[@#$%^&+=]) a special character must occur at least once
       (?=\\S+$) no whitespace allowed in the entire string
      .{8,} at least 8 characters

	 */
	
	private boolean checkPasswordStrngth(String password) {
		String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
		Pattern pattern = Pattern.compile(passwordRegex);
		Matcher matcher = pattern.matcher(password);
		return  matcher.matches();
			}

	private boolean checkPhoneNumberValidOrNot(String phoneNumber) {
		String phoneNumberRegEx = "^\\d{10}$";
		Pattern pattern = Pattern.compile(phoneNumberRegEx);
	    Matcher matcher = pattern.matcher(phoneNumber);
	    return  matcher.matches();
	    
	}

	/*
	 * RFC5322  Email Validation.
	 */
	 private boolean checkEmailValidOrNot(String email) {
        String emailRegex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
        
	}

	private boolean checkInputString(String input) {
	        return (input == null || input.trim().length() == 0);
	    }

}
