package com.learning.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.learning.bookstore.dto.SignupRequestDto;
import com.learning.bookstore.dto.loginDTO;
import com.learning.bookstore.response.ApiResponse;
import com.learning.bookstore.service.LoginService;
import com.learning.bookstore.utils.JwtUtills;

@RestController
public class SignupController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private JwtUtills jwtUtills;
	
	@PostMapping("/signup")
	public ResponseEntity<ApiResponse> createNewUser(@RequestBody SignupRequestDto signupRequestDto)
	{
		ApiResponse apiResponse = loginService.createUser(signupRequestDto);
		
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse> login(@RequestBody loginDTO logindto)
	{
		ApiResponse apiResponse = loginService.login(logindto);
		
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	@GetMapping("/privateApi")
	public ResponseEntity<ApiResponse> privateApi(@RequestHeader(value = "accessToken",defaultValue = "")String auth) throws Exception
	{
		ApiResponse apiResponse = new ApiResponse();
		
		jwtUtills.verify(auth);
        apiResponse.setData("this is private api");
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
}
