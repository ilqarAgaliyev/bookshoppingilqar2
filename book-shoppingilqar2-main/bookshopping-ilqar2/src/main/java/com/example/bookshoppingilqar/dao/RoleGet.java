package com.example.bookshoppingilqar.dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bookshoppingilqar.entity.Roles;

@Repository
public class RoleGet implements RoleDao{
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public Roles findByRoleName(String roleName) {
		
		Session session = factory.getCurrentSession();
		
		Query<Roles> query = session.createQuery("from Role where name=:role",Roles.class);
		query.setParameter("role", roleName);
		
		Roles role= null;
		try {
		role = query.getSingleResult();
		}catch (Exception e) {
			role = null;
		}
		return role;
	}
}
