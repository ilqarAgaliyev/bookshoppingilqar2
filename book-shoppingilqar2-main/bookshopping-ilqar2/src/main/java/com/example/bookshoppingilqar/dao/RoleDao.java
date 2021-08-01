package com.example.bookshoppingilqar.dao;

import com.example.bookshoppingilqar.entity.Roles;

public interface RoleDao {
	public Roles findByRoleName(String roleName);
}
