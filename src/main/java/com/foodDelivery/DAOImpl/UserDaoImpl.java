package com.foodDelivery.DAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodDelivery.DAO.UserDao;
import com.foodDelivery.Models.User;

public class UserDaoImpl implements UserDao{
	
	private static Connection con = null;
	private static Statement stat = null;
	private static PreparedStatement stmt = null;
	private static ResultSet res = null;
	
	public UserDaoImpl() {
		con = com.foodDelivery.util.DBConnectionUtil.getConnection();
	}
	
	private static final String INSERT_QUERY = "INSERT into `user` (`UserID`, `UserName`, `Password`, `Email`, `Address`, `ROLE`) values (?, ?, ?, ?, ?)";
	private static final String SELECT_QUERY = "SELECT * from `user` WHERE `UserID`=?"; 
	private static final String Update_QUERY = "UPDATE `user` set `UserName`=?, `Password`=?, `Email`=?, `Address`=?, `ROLE`=? WHERE `UserID`=?";      
	private static final String Delete_QUERY = "DELETE from `user` WHERE `UserID`=?"; 
	private static final String SELECTALL_QUERY = "SELECT * from `user`";
	
	
	@Override
	public void addUser(User user) {
		try {
			stmt = con.prepareStatement(INSERT_QUERY);
			stmt.setInt(1, user.getUserID());
			stmt.setString(2, user.getUserName());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getEmail());
			stmt.setString(5, user.getAddress());
			stmt.setString(6, user.getROLE());
			int i = stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUser(int userId) {
		try {
			stmt = con.prepareStatement(SELECT_QUERY);
			stmt.setInt(1, userId);
			res = stmt.executeQuery();
			
			while(res.next()) {
				int userId1 = res.getInt("UserID");
				String userName = res.getString("UserName");
				String password = res.getString("Password");
				String email = res.getString("Email");
				String address = res.getString("Address");
				String role = res.getString("ROLE");
				
				return new User(userId1, userName, password, email, address, role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateUser(User user) {
		try {
			stmt = con.prepareStatement(Update_QUERY);
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getAddress());
			stmt.setString(5, user.getROLE());
			stmt.setInt(6, user.getUserID());
			int i = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(int userId) {
		try {
			stmt = con.prepareStatement(Delete_QUERY);
			stmt.setInt(1, userId);
			int i = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getAllUsers() {
		ArrayList<User> list = new ArrayList<>();
		try {
			stmt = con.prepareStatement(SELECTALL_QUERY);
			res = stmt.executeQuery();
			while(res.next()) {
				int userId1 = res.getInt("UserID");
				String userName = res.getString("UserName");
				String password = res.getString("Password");
				String email = res.getString("Email");
				String address = res.getString("Address");
				String role = res.getString("ROLE");
				
				User us = new User(userId1, userName, password, email, address, role);
				list.add(us);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
