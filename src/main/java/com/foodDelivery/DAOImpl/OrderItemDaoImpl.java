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

import com.foodDelivery.DAO.OrderItemDao;
import com.foodDelivery.Models.OrderHistory;
import com.foodDelivery.Models.OrderItem;

public class OrderItemDaoImpl implements OrderItemDao{
	
	private static Connection con = null;
	private static Statement stat = null;
	private static PreparedStatement stmt = null;
	private static ResultSet res = null;
	
	public OrderItemDaoImpl() {
		con = com.foodDelivery.util.DBConnectionUtil.getConnection();
	}
	
	private static final String INSERT_QUERY = "INSERT into `OrderItem` (`OrderItemID`, `OrderID`, `MenuID`, `Quantity`, `ItemTotal`) values (?, ?, ?, ?, ?)";
	private static final String SELECT_QUERY = "SELECT * from `OrderItem` WHERE `OrderItemID`=?";
	private static final String Update_QUERY = "UPDATE `OrderItem` set `OrderID`=?, `MenuID`=?, `Quantity`=?, `ItemTotal`=? WHERE `OrderItemID`=?";      
	private static final String Delete_QUERY = "DELETE from `OrderItem` WHERE `OrderItemID`=?";
	private static final String SELECTALL_QUERY = "SELECT * from `OrderItem`";

	@Override
	public void addOrderItem(OrderItem orderItem) {
		try {
			stmt = con.prepareStatement(INSERT_QUERY);
			stmt.setInt(1, orderItem.getOrderItemID());
			stmt.setInt(2, orderItem.getOrderID());
			stmt.setInt(3, orderItem.getMenuID());
			stmt.setInt(4, orderItem.getQuantity());
			stmt.setDouble(5, orderItem.getItemTotal());
			int i = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderItem getOrderItem(int orderItemId) {
		try {
			stmt = con.prepareStatement(SELECT_QUERY);
			stmt.setInt(1, orderItemId);
			res = stmt.executeQuery();
			
			while(res.next()) {
				int orderitemId = res.getInt("OrderItemID");
				int orderIdd = res.getInt("OrderID");
				int menuIdd = res.getInt("MenuID");
				int quan = res.getInt("Quantity");
				double itemtot = res.getDouble("ItemTotal");
				
				return new OrderItem(orderitemId, orderIdd, menuIdd, quan, itemtot);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		try {
			stmt = con.prepareStatement(Update_QUERY);
			stmt.setInt(1, orderItem.getOrderID());
			stmt.setInt(2, orderItem.getMenuID());
			stmt.setInt(3, orderItem.getQuantity());
			stmt.setDouble(4, orderItem.getItemTotal());
			stmt.setInt(5, orderItem.getOrderItemID());
			int i = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteorderItem(int orderItemId) {
		try {
			stmt = con.prepareStatement(Delete_QUERY);
			stmt.setInt(1, orderItemId);
			int i = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderItem> getOrderItemByOrder(int orderId) {
		ArrayList<OrderItem> list = new ArrayList<>();
		try {
			stmt = con.prepareStatement(SELECTALL_QUERY);
			res = stmt.executeQuery();
			while(res.next()) {
				int orderitemId = res.getInt("OrderItemID");
				int orderIdd = res.getInt("OrderID");
				int menuIdd = res.getInt("MenuID");
				int quan = res.getInt("Quantity");
				double itemtot = res.getDouble("ItemTotal");
				
				OrderItem ord = new OrderItem(orderitemId, orderIdd, menuIdd, quan, itemtot);
				list.add(ord);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
