package com.example.bookshoppingilqar.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.bookshoppingilqar.dao.BooksDao;
import com.example.bookshoppingilqar.entity.Books;
import com.example.bookshoppingilqar.entity.Users;
import com.example.bookshoppingilqar.service.BasketBooksService;
import com.example.bookshoppingilqar.service.BookService;

@Controller
@RequestMapping("/book-shopping/books")
public class Addbook {
	
	public static String dir = System.getProperty("user.dir")+"/files";
	
	BookService bookService;
	
	BooksDao bookDao;
	BasketBooksService basketBookService;
	@Autowired
	public Addbook(BookService theBookService,BasketBooksService theBasketBookService,BooksDao theBookDao) {
		bookService = theBookService;
		basketBookService = theBasketBookService;
		bookDao = theBookDao;
	}
	@RequestMapping("/addBook")
	public String customerAddBook(HttpServletRequest request,Model model) {
		Books book = new Books();
		Users user = new Users();
		user.setUsername(request.getParameter("username"));
		System.out.println(user.getUsername());
		model.addAttribute("theBook",book);
		model.addAttribute("theUser",user);
		return "addBook";
	}
	@RequestMapping("/new")
	public String bookSave(@ModelAttribute("theBook") Books customer,@RequestParam("imageFile") MultipartFile[] files,HttpServletRequest request,Model model) {
		StringBuilder fileName = new StringBuilder();
		for (MultipartFile file:files) {
			Path fileNameAndPath = Paths.get(dir, file.getOriginalFilename());
			fileName.append(file.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, file.getBytes());
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		Users user = new Users();
		user.setUsername(request.getParameter("username"));
		List<Books> books= bookDao.getBooksByUsername(user.getUsername());
		bookDao.saveBook(customer, user.getUsername());
		model.addAttribute("books",books);
		model.addAttribute("theUser",user);
		return "redirectToMyBooks";
	}
	@RequestMapping("/update")
	public String bookUpdate(@ModelAttribute("theBook") Books customer,@RequestParam("imageFile") MultipartFile[] files,HttpServletRequest request,Model model) {
		StringBuilder fileName = new StringBuilder();
		for (MultipartFile file:files) {
			Path fileNameAndPath = Paths.get(dir, file.getOriginalFilename());
			fileName.append(file.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, file.getBytes());
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Users user = new Users();
		user.setUsername(request.getParameter("username"));
		List<Books> books= bookDao.getBooksByUsername(user.getUsername());
		bookDao.saveUpdatedBook(customer,Integer.parseInt(request.getParameter("id")));
		model.addAttribute("books",books);
		model.addAttribute("theUser",user);
		return "redirectToMyBooks";
	}
	
}
