package com.app.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bookstore.VO.OrderInfoVO;
import com.app.bookstore.exceptions.InvalidAddressIdException;
import com.app.bookstore.exceptions.InvalidOrderException;
import com.app.bookstore.exceptions.ProductNotFoundException;
import com.app.bookstore.exceptions.UserIdNotFoundException;
import com.app.bookstore.repo.UsersRepo;
import com.app.bookstore.service.OrdersService;
import com.app.bookstore.validators.OrderDetailsValidator;

@RestController
public class OrderController {

@Autowired
OrderDetailsValidator orderDetailsValidator;
@Autowired
OrdersService ordersService;

@Autowired
UsersRepo usersRepo;

   /*
    * inputs -> userid, addressid.
    * validate address id and user id.
    */

	@PostMapping("/createOrder")
	public ResponseEntity<String> createOrder(@RequestBody OrderInfoVO orderInfo) throws InvalidOrderException, InvalidAddressIdException, UserIdNotFoundException, ProductNotFoundException{		
		
		ordersService.placeOrder(orderInfo);
        return new ResponseEntity<>("Successfully created",HttpStatus.OK);
	}
	
	
}
