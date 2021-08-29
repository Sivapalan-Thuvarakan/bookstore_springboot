package com.learning.bookstore.data;

import java.util.List;

import org.springframework.stereotype.Component;

import com.learning.bookstore.entity.Author;
import com.learning.bookstore.response.PaginationMeta;

@Component
public class AuthorData {

	private List<Author> author;
	private PaginationMeta paginationMeta;
	
	public List<Author> getAuthor() {
		return author;
	}
	public void setAuthor(List<Author> author) {
		this.author = author;
	}
	public PaginationMeta getPaginationMeta() {
		return paginationMeta;
	}
	public void setPaginationMeta(PaginationMeta paginationMeta) {
		this.paginationMeta = paginationMeta;
	}
	
}
