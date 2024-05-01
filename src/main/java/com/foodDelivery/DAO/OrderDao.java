package com.foodDelivery.DAO;

import java.util.List;

import com.foodDelivery.Models.Order;

public interface OrderDao {
	
	void addOrder(Order order);
	Order getOrder(int orderId);
	void updateOrder(Order order);
	void deleteOrder(int orderId);
	List<Order> getAllOrderByUser(int userId);
}
