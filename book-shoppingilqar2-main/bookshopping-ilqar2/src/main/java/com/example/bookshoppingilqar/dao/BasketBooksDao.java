package com.example.bookshoppingilqar.dao;

import com.example.bookshoppingilqar.entity.BasketBooks;


public interface BasketBooksDao {
	public BasketBooks findByUsername(String userName);
	
	public void saveBasketBook(BasketBooks basketBook);
}
