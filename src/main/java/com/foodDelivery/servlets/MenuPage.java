package com.foodDelivery.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodDelivery.DAOImpl.MenuDaoImpl;
import com.foodDelivery.DAOImpl.RestaurantDaoImpl;
import com.foodDelivery.Models.Menu;
import com.foodDelivery.Models.Restaurant;

/**
 * Servlet implementation class MenuPage
 */
@WebServlet("/Menu")
public class MenuPage extends HttpServlet {
	private MenuDaoImpl menuDao;
	private RestaurantDaoImpl restDetail;
	@Override
	public void init() throws ServletException {
		menuDao = new MenuDaoImpl();
		restDetail = new RestaurantDaoImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String restaurantId = request.getParameter("restaurantId");
		if(restaurantId != null) {
			try {
				List<Menu> menuByRestaurant = menuDao.getAllMenuByRestaurant(Integer.parseInt(restaurantId));
				request.setAttribute("menuList", menuByRestaurant);
			} catch (Exception e) {
				
			}
		}
		
//		String restId = request.getParameter("restaurantId");
		Restaurant restaurant = restDetail.getRestaurant(Integer.parseInt(restaurantId));
		request.setAttribute("restList", restaurant);
			
		RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
		rd.forward(request, response);
	}

}
