package com.example.bookshoppingilqar.dao;

import com.example.bookshoppingilqar.entity.Users;

public interface UserDao {
	public Users findByUsername(String userName);
	
	public void saveUser(Users user);
}
