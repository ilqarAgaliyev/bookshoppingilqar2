package com.example.bookshoppingilqar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Roles {
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Id
	@Column(name="username")
	 String username;
	
	@Column(name="authority")
	String role;

	public Roles() {
		super();
	}

	public Roles(String username, String role) {
		super();
		this.username = username;
		this.role = role;
	}
	
	
}
