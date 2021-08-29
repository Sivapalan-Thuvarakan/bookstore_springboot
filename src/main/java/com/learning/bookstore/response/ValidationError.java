package com.learning.bookstore.response;

public class ValidationError {

	private String target;
	private String message;
	
	
	public ValidationError(String target, String message) {
		super();
		this.target = target;
		this.message = message;
	}
	
	
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
