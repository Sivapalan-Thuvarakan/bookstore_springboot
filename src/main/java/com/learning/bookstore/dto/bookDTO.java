package com.learning.bookstore.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class bookDTO {

	
	private Long bookId;
	private String name;
	private String desc;
	private Integer publisedYear;
	private String bookType;
	
	private List<authorDTO> authordto;
	
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getPublisedYear() {
		return publisedYear;
	}
	public void setPublisedYear(Integer publisedYear) {
		this.publisedYear = publisedYear;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public List<authorDTO> getAuthordto() {
		return authordto;
	}
	public void setAuthordto(List<authorDTO> authordto) {
		this.authordto = authordto;
	}
	
	
}
