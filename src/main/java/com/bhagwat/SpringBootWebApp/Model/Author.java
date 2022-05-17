package com.bhagwat.SpringBootWebApp.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Author {

	@Id
	private long id;

	@NotBlank(message = "Name can not be empty")
	@Size(min = 5, max = 50, message = "Min 5 and Max 50 Characters Allowed")
	private String name;
	
	
	@NotBlank(message = "Email can not be empty")
	private String email;
	
	@OneToMany(mappedBy="author")
	private List<Book> books;

	public Author() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", email=" + email + ", books=" + books + "]";
	}

}
