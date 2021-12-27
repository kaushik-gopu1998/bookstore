package com.app.bookstore.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.bookstore.dto.Users;

@Controller
public class UserMaintenanceController {

	@PostMapping("/createUser")
	public ResponseEntity<String> createUser(Users user){
		
		
		return new ResponseEntity<>("user creation successfull", HttpStatus.OK);
		
	}
}
