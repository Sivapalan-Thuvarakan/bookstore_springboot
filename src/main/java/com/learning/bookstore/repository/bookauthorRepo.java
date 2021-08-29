package com.learning.bookstore.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.bookstore.entity.BookAuthor;

@Repository
public interface bookauthorRepo extends JpaRepository<BookAuthor, Long>{

	List<BookAuthor> findAllBybookId(Long bookId);
}
