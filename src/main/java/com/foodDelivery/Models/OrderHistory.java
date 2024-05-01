package com.foodDelivery.Models;

import java.sql.Date;

public class OrderHistory {
	private int OrderHistoryID;
	private int UserID;
	private int OrderID;
	private Date OrderDate;
	private float TotalAmount;
	private String status;
	
	public OrderHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderHistory(int orderHistoryID, int userID, int orderID, Date orderDate, float totalAmount,
			String status) {
		super();
		OrderHistoryID = orderHistoryID;
		UserID = userID;
		OrderID = orderID;
		OrderDate = orderDate;
		TotalAmount = totalAmount;
		this.status = status;
	}

	public int getOrderHistoryID() {
		return OrderHistoryID;
	}

	public void setOrderHistoryID(int orderHistoryID) {
		OrderHistoryID = orderHistoryID;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public Date getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}

	public float getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		TotalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
	
	
	
}
