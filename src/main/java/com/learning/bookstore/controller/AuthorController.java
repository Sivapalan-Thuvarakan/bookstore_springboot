package com.learning.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.bookstore.response.ApiResponse;
import com.learning.bookstore.service.authorService;

@RestController
public class AuthorController {

	@Autowired
	private authorService authorservice;
	
	@GetMapping("/authors")
	public ApiResponse getAllAuthors(Pageable pageable)
	{
		return authorservice.getAllAuthors(pageable);
	}
}
