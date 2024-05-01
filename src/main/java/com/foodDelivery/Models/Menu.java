package com.foodDelivery.Models;

public class Menu {
	private int MenuID;
	private int RestaurantID;
	private String ItemName;
	private String Description;
	private double Price;
	private boolean IsAvailable;
	private String imgPath;
	
	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Menu(int menuID, int restaurantID, String itemName, String description, double price, boolean isAvailable,
			String imgPath) {
		super();
		MenuID = menuID;
		RestaurantID = restaurantID;
		ItemName = itemName;
		Description = description;
		Price = price;
		IsAvailable = isAvailable;
		this.imgPath = imgPath;
	}

	public int getMenuID() {
		return MenuID;
	}

	public void setMenuID(int menuID) {
		MenuID = menuID;
	}

	public int getRestaurantID() {
		return RestaurantID;
	}

	public void setRestaurantID(int restaurantID) {
		RestaurantID = restaurantID;
	}

	public String getItemName() {
		return ItemName;
	}

	public void setItemName(String itemName) {
		ItemName = itemName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public boolean getIsAvailable() {
		return IsAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		IsAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Menu [MenuID=" + MenuID + ", RestaurantID=" + RestaurantID + ", ItemName=" + ItemName + ", Description="
				+ Description + ", Price=" + Price + ", IsAvailable=" + IsAvailable + ", imgPath=" + imgPath + "]";
	}
	
	
	
}
