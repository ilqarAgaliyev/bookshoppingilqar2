package com.example.bookshoppingilqar.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Orders {

	public Integer getCutomerId() {
		return cutomerId;
	}

	public void setCutomerId(Integer cutomerId) {
		this.cutomerId = cutomerId;
	}

	public List<BasketBooks> getBooks() {
		return books;
	}

	public void setBooks(List<BasketBooks> books) {
		this.books = books;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	Integer id;
	
	@Column(name = "note")
	String note;
	
	@Column(name = "register")
	Date register;
	
	@Column(name = "totalPrice")
	Double totalPrice;
	
	@Column(name = "username")
	String username;
	
	@Column(name = "customerId" , insertable = false , updatable = false)
	Integer cutomerId;
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	@JoinColumn(name="customerId")
	Customer customer;
	
	@OneToMany(mappedBy = "order", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH },fetch = FetchType.LAZY)
	List<BasketBooks> books;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getRegister() {
		return register;
	}

	public void setRegister(Date register) {
		this.register = register;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Orders(String note, Date register, Double totalPrice, String username) {
		this.note = note;
		this.register = register;
		this.totalPrice = totalPrice;
		this.username = username;
	}

	public Orders() {
		super();
	}
	public void addBasketBook(BasketBooks book) {
		if (books == null) {
			books = new ArrayList<>();
		}

		books.add(book);

		book.setOrder(this);

	}
	
}
