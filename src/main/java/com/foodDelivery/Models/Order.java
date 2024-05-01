package com.foodDelivery.Models;

import java.sql.Date;

public class Order {
	private int OrderId;
	private int UserID;
	private int RestaurantID;
	private Date OrderDate;
	private double TotalAmount;
	private String status;
	private String PaymentMethod;
	
	public Order() {
		super();
	}
	
	public Order(int orderId, int userID, int restaurantID, Date orderDate, double totalAmount,
			String status, String paymentMethod) {
		super();
		OrderId = orderId;
		UserID = userID;
		RestaurantID = restaurantID;
		OrderDate = orderDate;
		TotalAmount = totalAmount;
		this.status = status;
		PaymentMethod = paymentMethod;
	}
	
	public int getOrderId() {
		return OrderId;
	}
	
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	
	public int getUserID() {
		return UserID;
	}
	
	public void setUserID(int userID) {
		UserID = userID;
	}
	
	public int getRestaurantID() {
		return RestaurantID;
	}
	
	public void setRestaurantID(int restaurantID) {
		RestaurantID = restaurantID;
	}
	
	public Date getOrderDate() {
		return OrderDate;
	}
	
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	
	public double getTotalAmount() {
		return TotalAmount;
	}
	
	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getPaymentMethod() {
		return PaymentMethod; 
	}
	
	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}
	
	
	
	
}
