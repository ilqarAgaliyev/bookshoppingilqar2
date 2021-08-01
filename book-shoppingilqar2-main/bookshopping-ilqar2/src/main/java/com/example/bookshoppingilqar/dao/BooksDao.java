package com.example.bookshoppingilqar.dao;

import java.util.List;

import com.example.bookshoppingilqar.entity.Books;


public interface BooksDao {
	public List<Books> getBooksByUsername(String username);
	public Books getBooksById(int id);
	public void saveBook(Books book,String username);
	public void saveUpdatedBook(Books book,int id);
	public void deleteBook(Books book,int id);
	public void updateBook(Books book, int id);
}
