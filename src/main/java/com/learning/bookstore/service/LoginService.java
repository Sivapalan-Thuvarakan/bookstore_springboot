package com.learning.bookstore.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.bookstore.dto.SignupRequestDto;
import com.learning.bookstore.dto.loginDTO;
import com.learning.bookstore.entity.User;
import com.learning.bookstore.repository.userRepo;
import com.learning.bookstore.response.ApiResponse;
import com.learning.bookstore.utils.JwtUtills;

@Service
public class LoginService {

	@Autowired
	private userRepo userrepository;
	
	@Autowired
	private JwtUtills jwtUtills;
	
	public ApiResponse createUser(SignupRequestDto signupRequestDto) {
		ApiResponse apiResponse = new ApiResponse();
		
		//validate signup data
		
		//convert DTO into Entity
		User user = new User();
		user.setName(signupRequestDto.getName());
		user.setEmailId(signupRequestDto.getEmailId());
		user.setGender(signupRequestDto.getGender());
		user.setPhoneNumber(signupRequestDto.getPhoneNumber());
		user.setPassword(signupRequestDto.getPassword());
		user.setIsActive(Boolean.TRUE);
	
		//store Entity
		userrepository.save(user);
		String token = jwtUtills.generateKey(user);
		Map<String, Object> data = new HashMap<>();
		data.put("accessToken", token);
	    apiResponse.setData(data);;
		return apiResponse;
	}

	
	
	public ApiResponse login(loginDTO logindto) {
		//validation
		
		//verify user exist with given user emailid and password
		User user = userrepository.findOneByEmailIdIgnoreCaseAndPassword(logindto.getEmailId(),logindto.getPassword());
		ApiResponse apiResponse = new ApiResponse();
		if(user == null)
		{
			 apiResponse.setData("user Login failed");
			 return apiResponse;
		}
		String token = jwtUtills.generateKey(user);
		Map<String, Object> data = new HashMap<>();
		data.put("accessToken", token);
	    apiResponse.setData(data);
	    return apiResponse;
	}

}
