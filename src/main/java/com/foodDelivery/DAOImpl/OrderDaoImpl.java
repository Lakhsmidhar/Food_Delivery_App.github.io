package com.foodDelivery.DAOImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodDelivery.DAO.OrderDao;
import com.foodDelivery.Models.Order;
import com.foodDelivery.Models.User;

public class OrderDaoImpl implements OrderDao {
	
	private static Connection con = null;
	private static Statement stat = null;
	private static PreparedStatement stmt = null;
	private static ResultSet res = null;
	
	public OrderDaoImpl() {
		con = com.foodDelivery.util.DBConnectionUtil.getConnection();
	}
	
	private static final String INSERT_QUERY = "INSERT into `OrderTable` (`OrderId`, `UserID`, `RestaurantID`, `OrderDate`, `TotalAmount`, `status`, `PaymentMethod`) values (?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_QUERY = "SELECT * from `OrderTable` WHERE `OrderId`=?"; 
	private static final String Update_QUERY = "UPDATE `OrderTable` set `UserID`=?, `RestaurantID`=?, `OrderDate`=?, `TotalAmount`=?, `status`=?, `PaymentMethod`=? WHERE `OrderId`=?";      
	private static final String Delete_QUERY = "DELETE from `OrderTable` WHERE `OrderId`=?"; 
	private static final String SELECTALL_QUERY = "SELECT * from `OrderTable`";

	@Override
	public void addOrder(Order order) {
		try {
			stmt = con.prepareStatement(INSERT_QUERY);
			stmt.setInt(1, order.getOrderId());
			stmt.setInt(2, order.getUserID());
			stmt.setInt(3, order.getRestaurantID());
			stmt.setDate(4, order.getOrderDate());
			stmt.setDouble(5, order.getTotalAmount());
			stmt.setString(6, order.getStatus());
			stmt.setString(6, order.getPaymentMethod());
			int i = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Order getOrder(int orderId) {
		try {
			stmt = con.prepareStatement(SELECT_QUERY);
			stmt.setInt(1, orderId);
			res = stmt.executeQuery();
			
			while(res.next()) {
				int orderId1 = res.getInt("OrderId");
				int userId = res.getInt("UserID");
				int restaurantId = res.getInt("RestaurantID");
				Date orderDate = res.getDate("OrderDate");
				double totalAmount = res.getDouble("TotalAmount");
				String status = res.getString("status");
				String paymentMethod = res.getString("PaymentMethod");
				
				return new Order(orderId1, userId, restaurantId, orderDate, totalAmount, status, paymentMethod);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateOrder(Order order) {
		try {
			stmt = con.prepareStatement(Update_QUERY);
			stmt.setInt(1, order.getUserID());
			stmt.setInt(2, order.getRestaurantID());
			stmt.setDate(3, order.getOrderDate());
			stmt.setDouble(4, order.getTotalAmount());
			stmt.setString(5, order.getStatus());
			stmt.setString(6, order.getPaymentMethod());
			stmt.setInt(7, order.getOrderId());
			int i = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(int orderId) {
		try {
			stmt = con.prepareStatement(Delete_QUERY);
			stmt.setInt(1, orderId);
			int i = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> getAllOrderByUser(int userId) {
		ArrayList<Order> list = new ArrayList<>();
		try {
			stmt = con.prepareStatement(SELECTALL_QUERY);
			res = stmt.executeQuery();
			while(res.next()) {
				int orderId1 = res.getInt("OrderId");
				int userId1 = res.getInt("UserID");
				int restaurantId = res.getInt("RestaurantID");
				Date orderDate = res.getDate("OrderDate");
				double totalAmount = res.getDouble("TotalAmount");
				String status = res.getString("status");
				String paymentMethod = res.getString("PaymentMethod");
				
				Order ord = new Order(orderId1, userId1, restaurantId, orderDate, totalAmount, status, paymentMethod);
				list.add(ord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


}
