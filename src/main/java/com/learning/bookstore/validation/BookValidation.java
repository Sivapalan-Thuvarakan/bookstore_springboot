package com.learning.bookstore.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.bookstore.entity.Book;
import com.learning.bookstore.response.ValidationError;

@Component
public class BookValidation {

	public List<ValidationError> validationForCreateddBook(Book book)
	{
		List<ValidationError> validationErrors = new ArrayList<>();
		
		//Validation for name
		if(book.getName() == null)
		{
			ValidationError validatationError = new ValidationError("Name","Name is null,please enter name");
			validationErrors.add(validatationError);
		}
		
		//Validation for published year
		if(book.getPublisedYear() == null)
		{
			ValidationError validatationError = new ValidationError("Published year","published year is null,please enter published year");
			validationErrors.add(validatationError);
		}
		
		//Validation for Book Type
		if(book.getBookType() == null)
		{
			ValidationError validatationError = new ValidationError("Book Type","Book Type is null,please enter Book Type");
			validationErrors.add(validatationError);
		}
		
		
		return validationErrors;
	}
}
