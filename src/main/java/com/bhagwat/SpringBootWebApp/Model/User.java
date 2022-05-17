package com.bhagwat.SpringBootWebApp.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@NotBlank(message = "User Name can not be empty")
	@Size(min = 5, max = 50, message = "Min 5 and Max 50 Characters Allowed For Username")
	private String username;

	@NotBlank(message = "PassWord can not be empty")
	@Size(min = 5, max = 50, message = "Min 5 and Max 50 Characters Allowed For Password")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
	}
	
	
}
