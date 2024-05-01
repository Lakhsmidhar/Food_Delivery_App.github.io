package com.foodDelivery.Models;


public class User {
	private int UserID;
	private String UserName;
	private String Password;
	private String Email;
	private String Address;
	private String ROLE;
	
	public User() {
		super();
	}

	public User(int userID, String userName, String password, String email, String address, String rOLE) {
		super();
		UserID = userID;
		UserName = userName;
		Password = password;
		Email = email;
		Address = address;
		ROLE = rOLE;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getROLE() {
		return ROLE;
	}

	public void setROLE(String rOLE) {
		ROLE = rOLE;
	}
	
}
