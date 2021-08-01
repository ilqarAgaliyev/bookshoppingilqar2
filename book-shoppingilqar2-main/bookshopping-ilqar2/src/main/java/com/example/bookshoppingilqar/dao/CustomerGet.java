package com.example.bookshoppingilqar.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bookshoppingilqar.entity.Customer;

@Repository
public class CustomerGet implements CustomerDao{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void saveCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Hi Ilqar im in CustomerGet");
		System.out.println(customer.getId());
		System.out.println(customer.getName());
		System.out.println(customer.getEmail());
		System.out.println(customer.getPhone());
		System.out.println(customer.getAddress());
		System.out.println(customer.getNote());
		session.save(customer);
	}
}
