package com.foodDelivery.Models;

public class Restaurant {
	private int RestaurantID;
	private String Name;
	private String CuisineType;
	private int DeliveryTime;
	private String Address;
	private int AdminUserID;
	private double Rating;
	private boolean IsActive;
	private String ImagePath;
	
	
	public Restaurant() {
		
	}


	public Restaurant(int restaurantID, String name, String cuisineType, int deliveryTime, String address,
			int adminUserID, double rating, boolean isActive, String imagePath) {
		super();
		RestaurantID = restaurantID;
		Name = name;
		CuisineType = cuisineType;
		DeliveryTime = deliveryTime;
		Address = address;
		AdminUserID = adminUserID;
		Rating = rating;
		IsActive = isActive;
		ImagePath = imagePath;
	}


	public int getRestaurantID() {
		return RestaurantID;
	}


	public void setRestaurantID(int restaurantID) {
		RestaurantID = restaurantID;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getCuisineType() {
		return CuisineType;
	}


	public void setCuisineType(String cuisineType) {
		CuisineType = cuisineType;
	}


	public int getDeliveryTime() {
		return DeliveryTime;
	}


	public void setDeliveryTime(int deliveryTime) {
		DeliveryTime = deliveryTime;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public int getAdminUserID() {
		return AdminUserID;
	}


	public void setAdminUserID(int adminUserID) {
		AdminUserID = adminUserID;
	}


	public double getRating() {
		return Rating;
	}


	public void setRating(double rating) {
		Rating = rating;
	}


	public boolean getIsActive() {
		return IsActive;
	}


	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}


	public String getImagePath() {
		return ImagePath;
	}


	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}


	@Override
	public String toString() {
		return "Restaurant [RestaurantID=" + RestaurantID + ", Name=" + Name + ", CuisineType=" + CuisineType
				+ ", DeliveryTime=" + DeliveryTime + ", Address=" + Address + ", AdminUserID=" + AdminUserID
				+ ", Rating=" + Rating + ", IsActive=" + IsActive + ", ImagePath=" + ImagePath + "]";
	}



	
	
}
