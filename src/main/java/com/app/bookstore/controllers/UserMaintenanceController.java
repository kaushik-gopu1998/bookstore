package com.app.bookstore.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.app.bookstore.dto.Users;
import com.app.bookstore.exceptions.EmailIdExistsException;
import com.app.bookstore.repo.UsersRepo;

@Controller
public class UserMaintenanceController {

	@Autowired
	UsersRepo usersRepo;
	@PostMapping("/createUser")
	public ResponseEntity<String> createUser(@RequestBody Users user) throws EmailIdExistsException{
		
		if(usersRepo.findByEmail(user.getEmail())!=null) {
			throw new EmailIdExistsException("EmailId already exists.");
		}		
		Integer newUserId = usersRepo.getMaxUserId();
		user.setUserId(newUserId+1);
		usersRepo.save(user);
		return new ResponseEntity<>("successfully created!!",HttpStatus.OK);
	}
}
