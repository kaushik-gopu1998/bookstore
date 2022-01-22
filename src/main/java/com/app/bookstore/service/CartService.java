package com.app.bookstore.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bookstore.VO.AddToCartVO;
import com.app.bookstore.VO.CartItemVO;
import com.app.bookstore.VO.CartVO;
import com.app.bookstore.VO.ProductsVO;
import com.app.bookstore.dto.Cart;
import com.app.bookstore.dto.Products;
import com.app.bookstore.dto.Users;
import com.app.bookstore.repo.CartRepo;

@Service
public class CartService {

	@Autowired
	CartRepo cartRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	public void addToCart(AddToCartVO addToCartVO, Products products, Users user) {
		Cart cart = new Cart(new Date(System.currentTimeMillis()), products,user,addToCartVO.getQuantity());
		cartRepo.save(cart);
	}
		
	public CartVO listCartItems(Users user) {
	List<Cart> cartList = cartRepo.findByUserId(user);
	List<CartItemVO> cartItems = new ArrayList<CartItemVO>();
	for(Cart cart : cartList) {
		CartItemVO cartItemVO = getDtoFromCart(cart);
		cartItems.add(cartItemVO);
	}
	float totalCost=0;
	for(CartItemVO cartItemVO : cartItems) {
		totalCost=totalCost+ (cartItemVO.getProduct().getPrice() * cartItemVO.getQuantity());
	}
	return new CartVO(cartItems,totalCost);
	}
	
	public  CartItemVO getDtoFromCart(Cart cart) {
        return new CartItemVO(cart.getCartId(),cart.getQuantity(), map(cart.getProduct(),ProductsVO.class));
    }
		
	<S, T> T map(S source, Class<T> targetClass) {
	    return modelMapper.map(source, targetClass);
	}

	public void removeItemFromCart(Integer cartItemId)   {
		cartRepo.deleteById(cartItemId);	
	}
	
	public void deleteUserCartItems(Users user) {
		cartRepo.deleteByUsers(user);
	}
}
