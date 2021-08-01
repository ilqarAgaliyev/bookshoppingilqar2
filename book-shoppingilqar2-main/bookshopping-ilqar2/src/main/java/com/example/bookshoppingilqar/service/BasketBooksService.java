package com.example.bookshoppingilqar.service;

import java.util.List;

import com.example.bookshoppingilqar.entity.BasketBooks;

public interface BasketBooksService {
	public List<BasketBooks> findAll();
	public BasketBooks findById(int theId);
}
