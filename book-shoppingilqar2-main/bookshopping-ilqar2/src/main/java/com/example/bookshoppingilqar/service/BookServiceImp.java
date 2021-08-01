package com.example.bookshoppingilqar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookshoppingilqar.dao.BooksRepository;
import com.example.bookshoppingilqar.entity.Books;

@Service
public class BookServiceImp implements BookService{

	BooksRepository bookRepository;
	
	@Autowired
	public BookServiceImp(BooksRepository theBooksRepository) {
		bookRepository = theBooksRepository;
	}
	
	@Override
	public List<Books> findAll() {
		return bookRepository.findAllByOrderByUsernameAsc();
	}

	@Override
	public Books findById(int theId) {
		Optional<Books> result = bookRepository.findById(theId);
		Books book = null;
		if(result.isPresent()) {
			book = result.get();
		}else {
			throw new RuntimeException("There is no book with id:"+theId);
		}
		return book;
	}

	@Override
	public void saveEmp(Books book) {
		bookRepository.save(book);		
	}

	@Override
	public void deleteById(int theId) {
		bookRepository.deleteById(theId);
		
	}

}
