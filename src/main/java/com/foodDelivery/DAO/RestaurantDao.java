package com.foodDelivery.DAO;

import java.util.List;

import com.foodDelivery.Models.Restaurant;

public interface RestaurantDao {
	
	void addRestaurant(Restaurant restaurant);
	Restaurant getRestaurant(int restaurantId);
	void updateRestaurant(Restaurant restaurant);
	void deleteRestaurant(int restaurantId);
	List<Restaurant> getAllRestaurants();
	
}
