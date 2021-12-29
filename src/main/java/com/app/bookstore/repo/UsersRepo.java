package com.app.bookstore.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.bookstore.dto.Users;

@Repository
@Transactional
public interface UsersRepo extends JpaRepository<Users,Integer>{
	Users findByEmail(String email);

	@Query(value="select max(user_id) from users",nativeQuery=true)
	public Integer getMaxUserId();
}
