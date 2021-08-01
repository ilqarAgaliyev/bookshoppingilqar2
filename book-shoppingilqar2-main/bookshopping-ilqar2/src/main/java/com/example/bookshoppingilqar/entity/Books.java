package com.example.bookshoppingilqar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Books {

	@Override
	public String toString() {
		return "Books [author=" + author + ", description=" + description + ", image=" + image
				+ ", name=" + name + ", page_count=" + page_count + ", price=" + price + ", username=" + username + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "author")
	String author;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "image")
	String image;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "page_count")
	Integer page_count;
	
	@Column(name = "price")
	Integer price;
	
	@Column(name = "username")
	String username;
	
	public Books() {
		
	}
	public Books(String author, String description, String image, String name, Integer page_count,
			Integer price, String username) {
		this.author = author;
		this.description = description;
		this.image = image;
		this.name = name;
		this.page_count = page_count;
		this.price = price;
		this.username = username;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPage_count() {
		return page_count;
	}
	public void setPage_count(Integer page_count) {
		this.page_count = page_count;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
}
