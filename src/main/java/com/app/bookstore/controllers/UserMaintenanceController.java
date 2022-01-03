package com.app.bookstore.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.bookstore.dto.Users;
import com.app.bookstore.exceptions.EmailIdExistsException;
import com.app.bookstore.exceptions.InvalidInputException;
import com.app.bookstore.exceptions.UserIdNotFoundException;
import com.app.bookstore.repo.UsersRepo;
import com.app.bookstore.validators.UserDetailsValidator;
@RestController
public class UserMaintenanceController {

	@Autowired
	UsersRepo usersRepo;
	@Autowired
	UserDetailsValidator userDetailsValidator;
	@PostMapping("/createUser")
	
	
	public ResponseEntity<String> createUser(@RequestBody  Users user, BindingResult result) throws EmailIdExistsException, InvalidInputException{
		
		performUserDataValidation(user, result);		
		if(usersRepo.findByEmail(user.getEmail())!=null) {
			throw new EmailIdExistsException("Invalid Entry");
		}		
		Integer newUserId = usersRepo.getMaxUserId();
		user.setUserId(newUserId+1);
		usersRepo.save(user);
		return new ResponseEntity<>("successfully created!!",HttpStatus.OK);
	}
	

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<String> updateUser(@PathVariable("id") Integer id, @RequestBody Users newData, BindingResult result) throws UserIdNotFoundException, InvalidInputException{
		performUserDataValidation(newData, result);
		 if(usersRepo.findById(id).isPresent())
		 {
		 Users oldData =  usersRepo.findById(id).get();
		 oldData.setFirstName(newData.getFirstName());
		 oldData.setLastName(newData.getLastName());
		 oldData.setEmail(newData.getEmail());
		 oldData.setPassword(newData.getPassword());
		 oldData.setCity(newData.getCity());
		 usersRepo.save(oldData);
		 return new ResponseEntity<>("successfully updated!!",HttpStatus.OK);
		 }
		 else 
		 {		 
		 throw new UserIdNotFoundException("user id not found!");
		 }		
	}
	

	private void performUserDataValidation(Users user, BindingResult result) throws InvalidInputException {
		userDetailsValidator.validate(user, result);
		if(result.hasErrors())
		throw new InvalidInputException("Invalid Entry");
	}
	
	
}
