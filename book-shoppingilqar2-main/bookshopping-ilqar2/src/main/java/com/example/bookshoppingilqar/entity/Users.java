package com.example.bookshoppingilqar.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class Users {

	@Id
	@Column(name="username")
	String username;
	
	@Column(name="password")
	String password;
	
	@Column(name="enabled")
	Integer enabled;

	@ManyToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="book",joinColumns = @JoinColumn(name="username"))
	Collection<Books> books;
	
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="orders",joinColumns = @JoinColumn(name="username"))
	List<Orders> orders;
	
	public void addOrder(Orders order) {
		if(orders==null) {
			orders = new ArrayList<>();
		}
		orders.add(order);
	}

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

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public Users(String username, String password,Integer enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public Users() {
		super();
	}
	
	
}
