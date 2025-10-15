package com.symbiosis.mywebsite.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Adminlogin {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @NotBlank(message = "Email cannot be blank")
	 @Email(message = "Invalid email format")
	 private String email;
	 
	 @NotBlank(message = "Password cannot be blank")
	 @Size(min = 6, message = "Password must be at least 6 characters long")
	 private String password;

	public int getAid() {
		return id;
	}

	public void setAid(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	 

}
