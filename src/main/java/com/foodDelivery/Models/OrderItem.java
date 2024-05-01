package com.foodDelivery.Models;

public class OrderItem {
	private int OrderItemID;
	private int OrderID;
	private int MenuID;
	private int Quantity;
	private double ItemTotal;
	
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(int orderItemID, int orderID, int menuID, int quantity, double itemTotal) {
		super();
		OrderItemID = orderItemID;
		OrderID = orderID;
		MenuID = menuID;
		Quantity = quantity;
		ItemTotal = itemTotal;
	}

	public int getOrderItemID() {
		return OrderItemID;
	}

	public void setOrderItemID(int orderItemID) {
		OrderItemID = orderItemID;
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public int getMenuID() {
		return MenuID;
	}

	public void setMenuID(int menuID) {
		MenuID = menuID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getItemTotal() {
		return ItemTotal;
	}

	public void setItemTotal(double itemTotal) {
		ItemTotal = itemTotal;
	}
	
}
