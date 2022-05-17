package com.bhagwat.SpringBootWebApp.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


@Entity
public class Book {

	@Id
	private long bookCode;
	
	@ManyToOne
	private Author author;
	
	private String name;
	
	@JsonFormat(pattern="yyyy-MM-dd",shape=Shape.STRING)
	private String date;

	public long getBookCode() {
		return bookCode;
	}

	public void setBookCode(long bookCode) {
		this.bookCode = bookCode;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Book(long bookCode, Author author, String name, String date) {
		super();
		this.bookCode = bookCode;
		this.author = author;
		this.name = name;
		this.date = date;
	}

	public Book() {
		super();
	}
	
	
	
}
