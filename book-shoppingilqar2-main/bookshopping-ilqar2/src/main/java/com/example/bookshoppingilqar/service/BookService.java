package com.example.bookshoppingilqar.service;

import java.util.List;
import com.example.bookshoppingilqar.entity.Books;

public interface BookService {
	public List<Books> findAll();
	public Books findById(int theId);
	public void saveEmp(Books emp);
	public void deleteById(int theId);
}
