package com.learning.bookstore.response;

public class AccessDeniedException extends RuntimeException {

	public AccessDeniedException (String message)
	{
		super(message);
	}
}
