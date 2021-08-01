package com.example.bookshoppingilqar.dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.bookshoppingilqar.entity.Books;

@Repository
public class BooksReader implements BooksDao{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public List<Books> getBooksByUsername(String username) {
		Session session =sessionFactory.getCurrentSession();
		Query<Books> query = session.createQuery("from Books b "+" WHERE b.username = '"+username+"'",Books.class);
		List<Books> books = query.getResultList();
		return books;
	}

	@Override
	public void saveBook(Books book,String username) {
		Session session = sessionFactory.getCurrentSession();
		Query<Books> query = session.createQuery("from Books b "+" WHERE b.username = '"+username+"'",Books.class);
		book.setUsername(username);
		System.out.println(book.getId());
		book.toString();
		session.save(book);
	}

	@Override
	public void deleteBook(Books book,int id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.beginTransaction();
		
		session.delete(book);
		tr.commit();
	}

	@Override
	public void updateBook(Books book, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Books getBooksById(int id) {
		Session session =sessionFactory.getCurrentSession();
		Query<Books> query = session.createQuery("from Books b "+" WHERE b.id = '"+id+"'",Books.class);
		List<Books> books = query.getResultList();
		Books book = new Books();
		book = books.get(0);
		return book;
	}

	@Override
	public void saveUpdatedBook(Books book, int id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		try {
			session.beginTransaction();
			session.createQuery("update Books set name = '"+book.getName()+"' , description = '"+book.getDescription()+"' , author = '"+book.getAuthor()+"' , price = '"+book.getPrice()+"' , image = '"+book.getImage()+"' , page_count = '"+book.getPage_count()+"' where id = '"+id+"'").executeUpdate();
			session.getTransaction().commit();
		}finally { 
			
			session.close();
		}
		
	}

}
