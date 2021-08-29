package com.learning.bookstore.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.bookstore.entity.Book;

@Repository
public interface bookStoreRepo extends JpaRepository<Book, Long> {

	//Single Request Param and single values
//	List<Book> findAllBypublisedYear(Integer publisedYear);
	
	//Single Request Param and Multiple values
	List<Book> findAllBypublisedYearIn(Set<Integer> publisedYear);
	
	//Multiple Request Param and Multiple values -- not working
//	List<Book> findAllBypublisedYearInAndbookType(Set<Integer> publisedYear,Set<String> bookType);
	
	
	//getAll Book by raw query
	String rawQuery="select * from books where published_year IN :yop";
	
	@Query(nativeQuery = true,value = rawQuery)
	List<Book> getBooksByRawQuery( @Param("yop")  Set<Integer> publisedYear);
}
