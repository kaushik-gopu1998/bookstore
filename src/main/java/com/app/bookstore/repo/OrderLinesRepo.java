package com.app.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.bookstore.dto.OrderLines;

public interface OrderLinesRepo extends JpaRepository<OrderLines, Integer> {

}
