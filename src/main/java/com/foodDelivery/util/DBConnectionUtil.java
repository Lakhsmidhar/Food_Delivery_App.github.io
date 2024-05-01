package com.foodDelivery.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/fooddeliveryapp";
	private static final String DATABASE_USER = "root";
	private static final String DATABASE_Password = "root";
	
	private static Connection con = null;
	
	private DBConnectionUtil() {
	}
	
	public static synchronized Connection getConnection() {
		if(con == null) {
			synchronized (DBConnectionUtil.class) {
				if(con == null) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						con = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_Password);
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return con;
	}
}