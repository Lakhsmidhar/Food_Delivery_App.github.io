package com.foodDelivery.DAO;

import java.util.List;

import com.foodDelivery.Models.OrderHistory;

public interface OrderHistoryDao {
	
	void addOrderHistory(OrderHistory orderHistory);
	OrderHistory getOrderHistory(int orderHistoryId);
	void updateOrderHistory(OrderHistory orderHistory);
	void deleteOrderHistory(int orderHistoryId);
	List<OrderHistory> getOrderHistoryByUser(int userId);
	
}
