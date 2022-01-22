package com.app.bookstore.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bookstore.VO.AddToCartVO;
import com.app.bookstore.VO.CartVO;
import com.app.bookstore.dto.Products;
import com.app.bookstore.dto.Users;
import com.app.bookstore.exceptions.ProductNotFoundException;
import com.app.bookstore.exceptions.UserIdNotFoundException;
import com.app.bookstore.repo.ProductRepo;
import com.app.bookstore.repo.UsersRepo;
import com.app.bookstore.service.CartService;
@RestController
public class CartController {

	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	ProductRepo productsRepo;
	
	@Autowired
	CartService cartService;
		
	@PostMapping("/add/{userId}")
	public ResponseEntity<String> addProductToCart(@PathVariable("userId") Integer userId,@RequestBody AddToCartVO addToCartVO) throws UserIdNotFoundException, ProductNotFoundException{
		Users user = usersRepo.findById(userId).orElseThrow(()->new UserIdNotFoundException("Invalid UserId"));
		Products products = productsRepo.findById(addToCartVO.getProductId()).orElseThrow(()->new ProductNotFoundException("Invalid Product Info"));
		cartService.addToCart(addToCartVO,products,user);
		return new ResponseEntity<>("product added to cart successfully", HttpStatus.CREATED);	
	}
		
	@GetMapping("/listCartItems/{userId}")
	public ResponseEntity<CartVO> getCartItems(@PathVariable("userId") Integer userId) throws UserIdNotFoundException{
	Users user = usersRepo.findById(userId).orElseThrow(()->new UserIdNotFoundException("Invalid UserId"));
	CartVO cartVO = cartService.listCartItems(user);
	return new ResponseEntity<CartVO>(cartVO,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{cartItemId}")
	public ResponseEntity<String> deleteCartItem(@PathVariable("cartItemId") Integer  cartItemId){ 
		
			cartService.removeItemFromCart(cartItemId);
			return new ResponseEntity<>("item removed from cart", HttpStatus.OK);
		  
		
	}
	
	
}
