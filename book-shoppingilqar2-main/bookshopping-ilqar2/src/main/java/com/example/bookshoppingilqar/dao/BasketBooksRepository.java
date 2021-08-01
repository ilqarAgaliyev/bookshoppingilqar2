package com.example.bookshoppingilqar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookshoppingilqar.entity.BasketBooks;


public interface BasketBooksRepository extends JpaRepository<BasketBooks,Integer>{
	
	public List<BasketBooks> findAllByOrderByIdAsc();
	
}

