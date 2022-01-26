package com.app.bookstore.controllers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.app.bookstore.dto.UserAddress;
import com.app.bookstore.dto.Users;
import com.app.bookstore.exceptions.EmailIdExistsException;
import com.app.bookstore.exceptions.InvalidInputException;
import com.app.bookstore.exceptions.UserIdNotFoundException;
import com.app.bookstore.repo.UsersAddressRepo;
import com.app.bookstore.repo.UsersRepo;
import com.app.bookstore.service.UsersService;
@RestController
public class UserMaintenanceController {

	private static final Logger logger = LoggerFactory.getLogger(UserMaintenanceController.class);
	@Autowired
	UsersRepo usersRepo;
	@Autowired
	UsersAddressRepo usersAddressRepo;
	@Autowired
	UsersService usersService;
	@PostMapping("/createUser")		
	public ResponseEntity<String> createUser(@RequestBody  Users user, BindingResult result) throws EmailIdExistsException, InvalidInputException{	
		usersService.performUserDataValidation(user, result);		
		if(usersRepo.findByEmail(user.getEmail())!=null) {
			logger.error("EmailId already exists!->{}",user.getEmail());
			throw new EmailIdExistsException("Invalid Entry");
		}		
		Integer newUserId = usersRepo.getMaxUserId();
		user.setUserId(newUserId+1);
		usersRepo.save(user);
		logger.info("user registration successfull");
		return new ResponseEntity<>("successfully created!!",HttpStatus.OK);
	}
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<String> updateUser(@PathVariable("id") Integer id, @RequestBody Users newData, BindingResult result) throws UserIdNotFoundException, InvalidInputException{
		 usersService.performUserDataValidation(newData, result);
		 Users oldData =  usersRepo.findById(id).orElseThrow(()->new UsernameNotFoundException("Invalid user id"));
		 oldData.setFirstName(newData.getFirstName());
		 oldData.setLastName(newData.getLastName());
		 oldData.setEmail(newData.getEmail());
		 oldData.setPassword(newData.getPassword());
		 oldData.setPhoneNumber(newData.getPhoneNumber());
		 usersRepo.save(oldData);
		 logger.info("update successfull!");
		 return new ResponseEntity<>("successfully updated!!",HttpStatus.OK);
		 
		 
	}
	
	@PostMapping("/addAddress/{userId}")
	public ResponseEntity<String> addAddressForUser(@PathVariable("userId") Integer userId,@RequestBody UserAddress address){
		Users user = usersRepo.findById(userId).orElseThrow(()->new UsernameNotFoundException("Invalid user id"));
		address.setUser(user);
		usersAddressRepo.save(address);
		return new ResponseEntity<>("address added!!",HttpStatus.CREATED);	
	}
	
	
}
