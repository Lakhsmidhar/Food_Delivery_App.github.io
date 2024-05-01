package com.foodDelivery.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodDelivery.DAOImpl.RestaurantDaoImpl;
import com.foodDelivery.Models.Restaurant;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RestaurantDaoImpl restDetail = new RestaurantDaoImpl();
		List<Restaurant> restaurants = restDetail.getAllRestaurants();
		
		request.setAttribute("restList", restaurants);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Home.jsp");
		rd.include(request, response);
		
	}
}