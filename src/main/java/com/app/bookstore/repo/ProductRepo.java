package com.app.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.bookstore.dto.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products,Integer> {

	@Query(value="select max(product_id) from products",nativeQuery=true)
	int getMaxProductId();

	}
