package com.learning.bookstore.response;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity handleException(Exception e)
	{
		
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		apiResponse.setError("oops..Some thing went wrong");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(apiResponse);
		
	}
	
	@ExceptionHandler
	public ResponseEntity handleException(BadRequestException e)
	{
		
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		apiResponse.setError(e.getError());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(apiResponse);
		
	}
	
	@ExceptionHandler
	public ResponseEntity handleException(AccessDeniedException e)
	{
		
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(apiResponse);
		
	}

}
