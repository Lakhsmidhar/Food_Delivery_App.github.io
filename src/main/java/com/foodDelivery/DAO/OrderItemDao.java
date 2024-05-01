package com.foodDelivery.DAO;

import java.util.List;

import com.foodDelivery.Models.OrderItem;

public interface OrderItemDao {
	
	void addOrderItem(OrderItem orderItem);
	OrderItem getOrderItem(int orderItemId);
	void updateOrderItem(OrderItem orderItem);
	void deleteorderItem(int orderItemId);
	List<OrderItem> getOrderItemByOrder(int orderId);
	
}
