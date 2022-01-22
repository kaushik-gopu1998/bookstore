package com.app.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.bookstore.dto.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Integer>{

}
