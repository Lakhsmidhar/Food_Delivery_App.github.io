package com.foodDelivery.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodDelivery.DAO.RestaurantDao;
import com.foodDelivery.Models.OrderItem;
import com.foodDelivery.Models.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao{
	
	private static Connection con = null;
	private static Statement stat = null;
	private static PreparedStatement stmt = null;
	private static ResultSet res = null;
	
	public RestaurantDaoImpl() {
		con = com.foodDelivery.util.DBConnectionUtil.getConnection();
	}
	
	private static final String INSERT_QUERY = "INSERT into `Restaurant` "
			+ "(`RestaurantID`, `Name`, `CuisineType`, `DeliveryTime`, `Address`, `AdminUserID`, `Rating`, `IsActive`, `ImagePath`) "
			+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SELECT_QUERY = "SELECT * from `Restaurant` WHERE `RestaurantID`=?";
	private static final String Update_QUERY = "UPDATE `Restaurant` set `OrderID`=?, `MenuID`=?, `Quantity`=?, `ItemTotal`=? WHERE `RestaurantID`=?";      
	private static final String Delete_QUERY = "DELETE from `Restaurant` WHERE `RestaurantID`=?";
	private static final String SELECTALL_QUERY = "SELECT * FROM fooddeliveryapp.restaurant";

	@Override
	public void addRestaurant(Restaurant restaurant) {
		try {
			stmt = con.prepareStatement(INSERT_QUERY);
			stmt.setInt(1, restaurant.getRestaurantID());
			stmt.setString(2, restaurant.getName());
			stmt.setString(3, restaurant.getCuisineType());
			stmt.setInt(4, restaurant.getDeliveryTime());
			stmt.setString(5, restaurant.getAddress());
			stmt.setInt(6, restaurant.getAdminUserID());
			stmt.setDouble(7, restaurant.getRating());
			stmt.setBoolean(8, restaurant.getIsActive());
			stmt.setString(9, restaurant.getImagePath());
			int i = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Restaurant getRestaurant(int restaurantId) {
		try {
			stmt = con.prepareStatement(SELECT_QUERY);
			stmt.setInt(1, restaurantId);
			res = stmt.executeQuery();
			
			while(res.next()) {
				int restId = res.getInt("RestaurantID");
				String name = res.getString("Name");
				String cuisinType = res.getString("CuisineType");
				int delvTime = res.getInt("DeliveryTime");
				String add = res.getString("Address");
				int adminUsId = res.getInt("AdminUserID");
				double rat = res.getDouble("Rating");
				boolean isAct = res.getBoolean("IsActive");
				String imagPath = res.getString("ImagePath");
				
				return new Restaurant(restId, name, cuisinType, delvTime, add, adminUsId, rat, isAct, imagPath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		try {
			stmt = con.prepareStatement(Update_QUERY);
			stmt.setString(1, restaurant.getName());
			stmt.setString(2, restaurant.getCuisineType());
			stmt.setInt(3, restaurant.getDeliveryTime());
			stmt.setString(4, restaurant.getAddress());
			stmt.setInt(5, restaurant.getAdminUserID());
			stmt.setDouble(6, restaurant.getRating());
			stmt.setBoolean(7, restaurant.getIsActive());
			stmt.setString(8, restaurant.getImagePath());
			stmt.setInt(9, restaurant.getRestaurantID());
			int i = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		try {
			stmt = con.prepareStatement(Delete_QUERY);
			stmt.setInt(1, restaurantId);
			int i = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> list = new ArrayList<>();
		try {
			stmt = con.prepareStatement(SELECTALL_QUERY);
			res = stmt.executeQuery();
			while(res.next()) {
				int restId = res.getInt("RestaurantID");
				String name = res.getString("Name");
				String cuisinType = res.getString("CuisineType");
				int delvTime = res.getInt("DeliveryTime");
				String add = res.getString("Address");
				int adminUsId = res.getInt("AdminUserID");
				double rat = res.getDouble("Rating");
				boolean isAct = res.getBoolean("IsActive");
				String imagPath = res.getString("ImagePath");
				
				Restaurant res = new Restaurant(restId, name, cuisinType, delvTime, add, adminUsId, rat, isAct, imagPath);
				list.add(res);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
