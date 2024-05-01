package com.foodDelivery.DAO;

import java.util.List;
import com.foodDelivery.Models.User;


public interface UserDao {
	
	void addUser(User user);
	User getUser(int userId);
	void updateUser(User user);
	void deleteUser(int userId);
	List<User> getAllUsers();
	
}
