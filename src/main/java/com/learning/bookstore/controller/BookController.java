package com.learning.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.sym.Name;
import com.learning.bookstore.dto.bookDTO;
import com.learning.bookstore.entity.Book;
import com.learning.bookstore.response.ApiResponse;
import com.learning.bookstore.service.bookStoreService;

import java.util.List;
import java.util.Set;

import javax.websocket.server.PathParam;

@RestController
public class BookController {
	
	@Autowired
	private bookStoreService bookstoreservice;

	//Using single Requset param and single value
//	@RequestMapping(value = "/books",method = RequestMethod.GET )
//	public List<Book> getAllBooks(@RequestParam(name = "yearOfPublication",required = false) Integer publisedYear)
//	{
//		return bookstoreservice.getAllBooks(publisedYear);
//	}
//	
	
	//Single Request param with multiple values	
	@RequestMapping(value = "/books",method = RequestMethod.GET )
	public List<Book> getAllBooks(@RequestParam(name = "yearOfPublication",required = false) Set<Integer> publisedYear)
	{
		return bookstoreservice.getAllBooks(publisedYear);
	}
	
	
	//Mutiple Request param with multiple values	
//	@RequestMapping(value = "/books",method = RequestMethod.GET )
//	public List<Book> getAllBooks(@RequestParam(name = "yearOfPublication",required = false) Set<Integer> publisedYear,
//			@RequestParam(name = "bookType",required = false) Set<String> bookType)
//	{
//		return bookstoreservice.getAllBooks(publisedYear,bookType);
//	}
//	
	
	@RequestMapping(value = "/books",method = RequestMethod.POST)
	public Book createBook(@RequestBody Book book)
	{
		return bookstoreservice.createBook(book);
	}
	
	@RequestMapping(value = "/books/{id}",method = RequestMethod.GET)
	public bookDTO getBookById(@PathVariable(name = "id") Long bookId,@RequestParam(name = "authorData",required = false) boolean authorData)
	{
		return bookstoreservice.getBookById(bookId,authorData);
	}
	
	@RequestMapping(value = "/books",method = RequestMethod.PUT)
	public Book updateBook(@RequestBody Book book) {
		return bookstoreservice.updateBookstore(book);
	}
	@RequestMapping(value = "/books/{id}",method = RequestMethod.DELETE)
	public String deleteBook(@PathVariable(name = "id") Long bookId)
	{
		return bookstoreservice.deletebook(bookId);
	}
	
	
	@GetMapping("/raw/books")
	public ApiResponse getBooksByRawQuery(@RequestParam(name = "YearOfPublished", required = false) Set<Integer> publisedYear){
		return bookstoreservice.getBooksByRawQuery(publisedYear);
	}
}
