package com.app.bookstore.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bookstore.VO.CartItemVO;
import com.app.bookstore.VO.CartVO;
import com.app.bookstore.VO.OrderInfoVO;
import com.app.bookstore.dto.OrderLines;
import com.app.bookstore.dto.Orders;
import com.app.bookstore.exceptions.InvalidAddressIdException;
import com.app.bookstore.exceptions.ProductNotFoundException;
import com.app.bookstore.exceptions.UserIdNotFoundException;
import com.app.bookstore.repo.OrderLinesRepo;
import com.app.bookstore.repo.OrdersRepo;
import com.app.bookstore.repo.ProductRepo;
import com.app.bookstore.repo.UsersAddressRepo;
import com.app.bookstore.repo.UsersRepo;

@Service
public class OrdersService {
@Autowired
UsersAddressRepo usersAddressRepo;
@Autowired
CartService cartService;
@Autowired
UsersRepo usersRepo;
@Autowired
OrdersRepo ordersRepo;

@Autowired
ProductRepo productsRepo;
@Autowired
OrderLinesRepo orderLinesRepo;
	public void placeOrder(OrderInfoVO orderInfo) throws InvalidAddressIdException, UserIdNotFoundException, ProductNotFoundException {
        CartVO cartVO = cartService.listCartItems(usersRepo.findById(orderInfo.getUserId()).orElseThrow(()->new UserIdNotFoundException("Invalid User Id!")));
        List<CartItemVO> cartItemsVo = cartVO.getCartItems();
		Orders order = new Orders();
		
		order.setOrderDate(new Date(System.currentTimeMillis()));
		order.setUserAdddress(usersAddressRepo.findById(orderInfo.getAddressId()).orElseThrow(()-> new InvalidAddressIdException("Invalid Input")));
		order.setUserId(usersRepo.findById(orderInfo.getUserId()).get());
		order.setTotalAmount(cartVO.getTotalCost());
		ordersRepo.save(order);
		
		for(CartItemVO cartItemVO : cartItemsVo) {
			OrderLines orderLine = new OrderLines();
			orderLine.setPrice(cartItemVO.getProduct().getPrice());
			orderLine.setProdcutId(productsRepo.findById(cartItemVO.getProduct().getProductId()).orElseThrow(()->new ProductNotFoundException("Invalid Product Information")));
			orderLine.setQuantity(cartItemVO.getQuantity());
			orderLine.setOrder(order);
			orderLinesRepo.save(orderLine);	
		}
		
		//delete cart items		
		cartService.deleteUserCartItems(usersRepo.findById(orderInfo.getUserId()).get());
	}

}
