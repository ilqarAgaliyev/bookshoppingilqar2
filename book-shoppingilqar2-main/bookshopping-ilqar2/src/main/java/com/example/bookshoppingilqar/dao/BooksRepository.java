package com.example.bookshoppingilqar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookshoppingilqar.entity.Books;


public interface BooksRepository extends JpaRepository<Books,Integer>{
	
	public List<Books> findAllByOrderByUsernameAsc();
	
}

