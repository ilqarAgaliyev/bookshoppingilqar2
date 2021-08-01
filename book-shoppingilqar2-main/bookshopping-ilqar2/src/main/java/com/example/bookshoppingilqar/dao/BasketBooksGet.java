package com.example.bookshoppingilqar.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bookshoppingilqar.entity.BasketBooks;

@Repository
public class BasketBooksGet implements BasketBooksDao{

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public BasketBooks findByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveBasketBook(BasketBooks basketBook) {
		Session session = sessionFactory.getCurrentSession();
		session.save(basketBook);
	}

}
