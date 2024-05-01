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

import com.foodDelivery.DAO.MenuDao;
import com.foodDelivery.Models.Menu;
import com.foodDelivery.Models.Order;

public class MenuDaoImpl implements MenuDao{
	
	private static Connection con = null;
	private static Statement stat = null;
	private static PreparedStatement stmt = null;
	private static ResultSet res = null;
	
	public MenuDaoImpl() {
		con = com.foodDelivery.util.DBConnectionUtil.getConnection();
	}
	
	private static final String INSERT_QUERY = "INSERT into `Menu` (`MenuID`, `RestaurantID`, `ItemName`, `Description`, `Price`, `IsAvailable`, `imgPath`) values (?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_QUERY = "SELECT * from `Menu` WHERE `MenuID`=?";
	private static final String Update_QUERY = "UPDATE `Menu` set `RestaurantID`=?, `ItemName`=?, `Description`=?, `Price`=?, `IsAvailable`=?, `imgPath`=? WHERE `MenuID`=?";      
	private static final String Delete_QUERY = "DELETE from `Menu` WHERE `MenuID`=?";
	private static final String SELECTALL_QUERY = "SELECT * from `Menu` WHERE `RestaurantID`=?";

	@Override
	public void addMenu(Menu menu) {
		try {
			stmt = con.prepareStatement(INSERT_QUERY);
			stmt.setInt(1, menu.getMenuID());
			stmt.setInt(2, menu.getRestaurantID());
			stmt.setString(3, menu.getItemName());
			stmt.setString(4, menu.getDescription());
			stmt.setDouble(5, menu.getPrice());
			stmt.setBoolean(6, menu.getIsAvailable());
			stmt.setString(7, menu.getImgPath());
			int i = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Menu getMenu(int menuId) {
		try {
			stmt = con.prepareStatement(SELECT_QUERY);
			stmt.setInt(1, menuId);
			res = stmt.executeQuery();
			
			while(res.next()) {
				int menuId1 = res.getInt("MenuID");
				int restaurantId = res.getInt("RestaurantID");
				String itemName = res.getString("ItemName");
				String description = res.getString("Description");
				double price = res.getDouble("Price");
				boolean isAvail = res.getBoolean("IsAvailable");
				String imgPath = res.getString("imgPath");
				
				return new Menu(menuId1, restaurantId, itemName, description, price, isAvail, imgPath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateMenu(Menu menu) {
		try {
			stmt = con.prepareStatement(Update_QUERY);
			stmt.setInt(1, menu.getRestaurantID());
			stmt.setString(2, menu.getItemName());
			stmt.setString(3, menu.getDescription());
			stmt.setDouble(4, menu.getPrice());
			stmt.setBoolean(5, menu.getIsAvailable());
			stmt.setInt(6, menu.getMenuID());
			stmt.setString(7, menu.getImgPath());
			
			int i = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMenu(int menuId) {
		try {
			stmt = con.prepareStatement(Delete_QUERY);
			stmt.setInt(1, menuId);
			int i = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Menu> getAllMenuByRestaurant(int restaurantId) {
		ArrayList<Menu> list = new ArrayList<>();
		try {
			stmt = con.prepareStatement(SELECTALL_QUERY);
			stmt.setInt(1, restaurantId);
			res = stmt.executeQuery();
			while(res.next()) {
				int menuId1 = res.getInt("MenuID");
				int restaurantId1 = res.getInt("RestaurantID");
				String itemName = res.getString("ItemName");
				String description = res.getString("Description");
				double price = res.getDouble("Price");
				boolean isAvail = res.getBoolean("IsAvailable");
				String imgPath = res.getString("imgPath");
				Menu men = new Menu(menuId1, restaurantId1, itemName, description, price, isAvail, imgPath);
				list.add(men);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
