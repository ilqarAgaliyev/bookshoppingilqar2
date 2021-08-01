package com.example.bookshoppingilqar.dao;

import com.example.bookshoppingilqar.entity.Orders;


public interface OrdersDao {
	public Orders findByUsername(String userName);
	
	public void saveOrder(Orders order);
}
