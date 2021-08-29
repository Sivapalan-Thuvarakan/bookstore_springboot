package com.learning.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String desc;
	
	@Column(name = "published_year")
	private Integer publisedYear;
	
	@Column(name = "book_type")
	private String bookType;
	
	public Book() {
		
	}
	
	
	public Book(Long id, String name, String desc, Integer publisedYear, String bookType) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.publisedYear = publisedYear;
		this.bookType = bookType;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long bookId) {
		this.id = id;
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
	
	
}
