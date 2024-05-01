package com.foodDelivery.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.valves.rewrite.RewriteCond;

import com.foodDelivery.DAOImpl.MenuDaoImpl;
import com.foodDelivery.Models.Cart;
import com.foodDelivery.Models.CartItem;
import com.foodDelivery.Models.Menu;
import com.mysql.cj.Session;


/**
 * Servlet implementation class cart
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		
		if(cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		String action = req.getParameter("action");
		if(action.equals("add")) {
			addItemCart(req, cart);
		}else if(action.equals("update")) {
			updateCartItem(req, cart);
		}else if(action.equals("remove")) {
			removeItemFromCart(req, cart);
		}
		
		resp.sendRedirect("cart.jsp");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}

	public void addItemCart(HttpServletRequest req, Cart cart) {
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		MenuDaoImpl menuDao = new MenuDaoImpl();
		Menu menuItem = menuDao.getMenu(itemId);
		
		
		HttpSession session = req.getSession();
		session.setAttribute("restaurantId", menuItem.getRestaurantID());
		
		if(menuItem != null) {
			CartItem item = new CartItem(menuItem.getMenuID(), menuItem.getRestaurantID(), menuItem.getItemName(), quantity, menuItem.getPrice());
			cart.addItem(item);
		}
	}

	public void updateCartItem(HttpServletRequest req, Cart cart) {
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		cart.updateItem(itemId, quantity);
	}
	
	public void removeItemFromCart(HttpServletRequest req, Cart cart) {
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		cart.removeItem(itemId);
	}
	
}
