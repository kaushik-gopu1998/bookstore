package com.app.bookstore.repo;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.app.bookstore.dto.Cart;
import com.app.bookstore.dto.Users;


public interface CartRepo extends JpaRepository<Cart,Integer> {
	List<Cart> findByUserId(Users user);

	List<Cart> deleteByUserId(Users user);
}
