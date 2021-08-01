package com.example.bookshoppingilqar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookshoppingilqar.dao.BasketBooksRepository;
import com.example.bookshoppingilqar.entity.BasketBooks;
@Service
public class BasketBooksServiceImp implements BasketBooksService{

	BasketBooksRepository basketBookRepository;
	BookService bookService;
	@Autowired
	public BasketBooksServiceImp(BasketBooksRepository theBooksRepository) {
		basketBookRepository = theBooksRepository;
	}
	
	@Override
	public List<BasketBooks> findAll() {
		return basketBookRepository.findAllByOrderByIdAsc();
	}

	@Override
	public BasketBooks findById(int theId) {
		Optional<BasketBooks> result = basketBookRepository.findById(theId);
		BasketBooks book = null;
		if(result.isPresent()) {
			book = result.get();
		}else {
			throw new RuntimeException("There is no book with id:"+theId);
		}
		return book;
	}

}
