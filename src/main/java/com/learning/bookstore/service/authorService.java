package com.learning.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.learning.bookstore.data.AuthorData;
import com.learning.bookstore.entity.Author;
import com.learning.bookstore.repository.authorRepo;
import com.learning.bookstore.response.ApiResponse;
import com.learning.bookstore.response.PaginationMeta;

@Service
public class authorService {

	@Autowired
	private authorRepo authorepo;
	
	public ApiResponse getAllAuthors(Pageable pageable) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();
		Page<Author> authorpage =  authorepo.findAll(pageable);
		
		List<Author> author = authorpage.getContent();
		PaginationMeta paginationMeta = PaginationMeta.createPagination(authorpage);
		
		AuthorData authorData = new AuthorData();
		authorData.setAuthor(author);
		authorData.setPaginationMeta(paginationMeta);
		
		apiResponse.setData(authorData);
		
		return apiResponse;
	}

}
