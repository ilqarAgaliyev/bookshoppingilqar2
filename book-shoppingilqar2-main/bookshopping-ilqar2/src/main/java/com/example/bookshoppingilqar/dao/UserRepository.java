package com.example.bookshoppingilqar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookshoppingilqar.entity.Users;

public interface UserRepository extends JpaRepository<Users,Integer>{
	
	public List<Users> findAllByOrderByUsernameAsc();
	public Users findByUsername(String username);
}
