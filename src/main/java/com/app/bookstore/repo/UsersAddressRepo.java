package com.app.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bookstore.dto.UserAddress;

@Repository
public interface UsersAddressRepo extends JpaRepository<UserAddress, Integer> {

}
