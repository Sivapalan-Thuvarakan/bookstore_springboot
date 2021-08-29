package com.learning.bookstore.response;

import java.util.List;

public class BadRequestException extends RuntimeException{

	private List<ValidationError> error;

	public List<ValidationError> getError() {
		return error;
	}

	public void setError(List<ValidationError> error) {
		this.error = error;
	}

	public BadRequestException(String message, List<ValidationError> error) {
		super(message);
		this.error=error;
	}
	
}
