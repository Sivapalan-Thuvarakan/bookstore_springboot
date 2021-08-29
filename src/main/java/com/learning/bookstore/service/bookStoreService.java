package com.learning.bookstore.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learning.bookstore.data.BookData;
import com.learning.bookstore.dto.authorDTO;
import com.learning.bookstore.dto.bookDTO;
import com.learning.bookstore.entity.Author;
import com.learning.bookstore.entity.Book;
import com.learning.bookstore.entity.BookAuthor;
import com.learning.bookstore.repository.bookStoreRepo;
import com.learning.bookstore.repository.bookauthorRepo;
import com.learning.bookstore.response.ApiResponse;
import com.learning.bookstore.response.BadRequestException;
import com.learning.bookstore.response.ValidationError;
import com.learning.bookstore.validation.BookValidation;

@Service
public class bookStoreService {
	@Autowired 
	private bookStoreRepo bookstorerepo;
	
	@Autowired 
	private bookauthorRepo bookauthorrepo;
	
	@Autowired
	private BookValidation bookValidation;
	
	//Single Request Param and Single value
//	public List<Book> getAllBooks(Integer publisedYear) {
//		//get all books
//		List<Book> books = new ArrayList<>();
//		if(publisedYear == null)
//		{
//			 books = bookstorerepo.findAll();
//		}
//		else {
//			books = bookstorerepo.publisedYear(publisedYear);
//		}
//		return books;
//	}

	//Single Request Param and Multiple values
	
	public List<Book> getAllBooks(Set<Integer> publisedYear) {
		//get all books
		List<Book> books = new ArrayList<>();
		if(publisedYear == null)
		{
			 books = bookstorerepo.findAll();
		}
		else {
			books = bookstorerepo.findAllBypublisedYearIn(publisedYear);
		}
		return books;
	}
	
	//Multiple Request Param and Multiple values 
//	
//	public List<Book> getAllBooks(Set<Integer> publisedYear,Set<String> bookType) {
//		//get all books
//		List<Book> books = new ArrayList<>();
//		if(publisedYear == null)
//		{
//			 books = bookstorerepo.findAll();
//		}
//		else {
//			books = bookstorerepo.findAllBypublisedYearInAndbookType(publisedYear,bookType);
//		}
//		return books;
//	}

	public  Book createBook(Book book) {
		
		//validation method
		List<ValidationError> validationError = bookValidation.validationForCreateddBook(book);
		
		//if validation is not success
		if(validationError.size()>0)
		{
			throw new BadRequestException("Bad Request",validationError);
		}
		
		//if validation is success
		// save Book
		return bookstorerepo.save(book);
	}

	public bookDTO getBookById(Long bookId,boolean authorData) {
		// get single book 
		Optional<Book> optional = bookstorerepo.findById(bookId);
		Book book = null;
		List<BookAuthor> optionalBookAuthor = null;
		if(optional.isPresent())
		{
			//get book details
			book = optional.get();
		}else {
			throw new RuntimeException("Book is not found");
		}
		
		//set book details
		bookDTO bookdto = new bookDTO();
		bookdto.setBookId(book.getId());
		bookdto.setName(book.getName());
		bookdto.setDesc(book.getDesc());
		bookdto.setPublisedYear(book.getPublisedYear());
		List<authorDTO> authorDTOS = new ArrayList<>();
		if(authorData)
		{
			//get author details
			 optionalBookAuthor = bookauthorrepo.findAllBybookId(bookId);
				for(BookAuthor bookAuthor : optionalBookAuthor)
				{
					authorDTO authordto = new authorDTO();
					Author author = bookAuthor.getAuthor();
					authordto.setAuthorId(author.getId());
					authordto.setName(author.getName());
					authordto.setGender(author.getGender());
					
					authorDTOS.add(authordto);
				}
				//set author details
				bookdto.setAuthordto(authorDTOS);
		}
		
		return bookdto;
	}

	public String deletebook(Long bookId) {
		// delete book
		 bookstorerepo.deleteById(bookId);
		 return "Deleted Success fully";
	}

	public Book updateBookstore(Book book) {
		// TODO Auto-generated method stub
		// 	update book
		return bookstorerepo.save(book);
	}
	
	public ApiResponse getBooksByRawQuery(Set<Integer> publisedYear)
	{
		ApiResponse apiResponse = new ApiResponse();
		List<Book> books = bookstorerepo.getBooksByRawQuery(publisedYear);
		
//		Map data = new HashMap<>();
//		data.put("books",books);
		
		BookData data = new BookData();
		data.setBook(books);
		
		apiResponse.setData(data);
		return apiResponse;
	}

}
