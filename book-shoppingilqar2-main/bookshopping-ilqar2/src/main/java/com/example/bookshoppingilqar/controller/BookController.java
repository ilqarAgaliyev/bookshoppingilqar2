package com.example.bookshoppingilqar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookshoppingilqar.entity.Books;
import com.example.bookshoppingilqar.service.BookService;

@Controller
public class BookController {
	
	BookService bookService;
	
	@Autowired
	public BookController(BookService theBookService) {
		bookService = theBookService;
	}
	@RequestMapping("/")
	public String viewBooksPage() {
		return "default-page";
	}
}
