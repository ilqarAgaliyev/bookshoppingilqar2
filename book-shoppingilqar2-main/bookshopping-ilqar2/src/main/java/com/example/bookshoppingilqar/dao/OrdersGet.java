package com.example.bookshoppingilqar.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bookshoppingilqar.entity.Orders;

@Repository
public class OrdersGet implements OrdersDao{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public Orders findByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrder(Orders order) {
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
	}

}
