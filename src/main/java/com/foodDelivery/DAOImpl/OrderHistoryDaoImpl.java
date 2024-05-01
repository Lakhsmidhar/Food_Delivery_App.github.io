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

import com.foodDelivery.DAO.OrderHistoryDao;
import com.foodDelivery.Models.Menu;
import com.foodDelivery.Models.OrderHistory;

public class OrderHistoryDaoImpl implements OrderHistoryDao{
	
	private static Connection con = null;
	private static Statement stat = null;
	private static PreparedStatement stmt = null;
	private static ResultSet res = null;
	
	public OrderHistoryDaoImpl() {
		con = com.foodDelivery.util.DBConnectionUtil.getConnection();
	}
	
	private static final String INSERT_QUERY = "INSERT into `OrderHistory` (`OrderHistoryID`, `UserID`, `OrderID`, `OrderDate`, `TotalAmount`, `status`) values (?, ?, ?, ?, ?, ?)";
	private static final String SELECT_QUERY = "SELECT * from `OrderHistory` WHERE `OrderHistoryID`=?";
	private static final String Update_QUERY = "UPDATE `OrderHistory` set `UserID`=?, `OrderID`=?, `OrderDate`=?, `TotalAmount`=?, `status`=? WHERE `OrderHistoryID`=?";      
	private static final String Delete_QUERY = "DELETE from `OrderHistory` WHERE `OrderHistoryID`=?";
	private static final String SELECTALL_QUERY = "SELECT * from `OrderHistory`";

	@Override
	public void addOrderHistory(OrderHistory orderHistory) {
		try {
			stmt = con.prepareStatement(INSERT_QUERY);
			stmt.setInt(1, orderHistory.getOrderHistoryID());
			stmt.setInt(2, orderHistory.getUserID());
			stmt.setInt(3, orderHistory.getOrderID());
			stmt.setDate(4, orderHistory.getOrderDate());
			stmt.setDouble(5, orderHistory.getTotalAmount());
			stmt.setString(6, orderHistory.getStatus());
			int i = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderHistory getOrderHistory(int orderHistoryId) {
		try {
			stmt = con.prepareStatement(SELECT_QUERY);
			stmt.setInt(1, orderHistoryId);
			res = stmt.executeQuery();
			
			while(res.next()) {
				int orderHisId = res.getInt("OrderHistoryID");
				int userId = res.getInt("UserID");
				int orderId = res.getInt("OrderID");
				Date orderdate = res.getDate("OrderDate");
				float totalamt = res.getFloat("TotalAmount");
				String status = res.getString("status");
				
				return new OrderHistory(orderHisId, userId, orderId, orderdate, totalamt, status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateOrderHistory(OrderHistory orderHistory) {
		try {
			stmt = con.prepareStatement(Update_QUERY);
			stmt.setInt(1, orderHistory.getUserID());
			stmt.setInt(2, orderHistory.getOrderID());
			stmt.setDate(3, orderHistory.getOrderDate());
			stmt.setDouble(4, orderHistory.getTotalAmount());
			stmt.setString(5, orderHistory.getStatus());
			stmt.setInt(6, orderHistory.getOrderHistoryID());
			int i = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrderHistory(int orderHistoryId) {
		try {
			stmt = con.prepareStatement(Delete_QUERY);
			stmt.setInt(1, orderHistoryId);
			int i = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderHistory> getOrderHistoryByUser(int userId) {
		ArrayList<OrderHistory> list = new ArrayList<>();
		try {
			stmt = con.prepareStatement(SELECTALL_QUERY);
			res = stmt.executeQuery();
			while(res.next()) {
				int orderHisId = res.getInt("OrderHistoryID");
				int userId1 = res.getInt("UserID");
				int orderId = res.getInt("OrderID");
				Date orderdate = res.getDate("OrderDate");
				float totalamt = res.getFloat("TotalAmount");
				String status = res.getString("status");
				
				OrderHistory ordHis = new OrderHistory(orderHisId, userId1, orderId, orderdate, totalamt, status);
				list.add(ordHis);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
