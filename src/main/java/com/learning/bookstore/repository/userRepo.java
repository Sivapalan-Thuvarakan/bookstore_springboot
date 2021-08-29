package com.learning.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.bookstore.entity.User;

@Repository
public interface userRepo extends JpaRepository<User, Long>{

	 User findOneByEmailIdIgnoreCaseAndPassword(String emailId, String password) ;
}
