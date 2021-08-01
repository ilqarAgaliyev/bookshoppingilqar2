package com.example.bookshoppingilqar.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bookshoppingilqar.entity.Users;

	@Repository
	public class UserGet implements UserDao{
		
		@Autowired
		SessionFactory sessionFactory;

		@Override
		public Users findByUsername(String userName) {
			Session session = sessionFactory.getCurrentSession();
			
			Query<Users> query = session.createQuery("from Users where username=:name",Users.class);
			
			query.setParameter("name", userName);
			
			Users user = null;
			try {
				user = query.getSingleResult();
			} catch (Exception e) {
				user = null;
			}
			
			
			return user;
		}

		@Override
		public void saveUser(Users user) {
			Session session = sessionFactory.getCurrentSession();
			session.save(user);
			
		}

	}