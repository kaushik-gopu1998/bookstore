package com.app.bookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.bookstore.dto.Users;

public interface UsersRepo extends JpaRepository<Users,Integer>{
}
