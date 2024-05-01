<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.HashMap, com.foodDelivery.Models.Cart, com.foodDelivery.Models.CartItem" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="CartStyle.css">
</head>
<body>
    <h1>Shopping Cart</h1>
    <div class="cart-items">
        <% 
        	Cart cart = (Cart) session.getAttribute("cart");
            if (cart != null && !cart.getItems().isEmpty()) {
                for (CartItem item: cart.getItems().values()) {
        %>
        
        <div class="cart-item">
            <div class="item-info">
                <h2><%= item.getName() %></h2>
                <p>Price: $<%= item.getPrice() %></p>
                <form action="cart" method="post">
                	<input type="hidden" name="itemId" value="<%=item.getItemId() %>">
                	<label>Quantity <input type="number" name="quantity" value="<%=item.getQuantity()%>" min="1"> </label>
                	<label> <input type="submit" name="action" value="update" class="update-btn"> </label>
                	<label> <input type="submit" name="action" value="remove" class="remove-btn"> </label>
        		</form>
        </div>
         <%
                }
            }else{
         
         %>     
         <p>Your Cart is Empty </p>
         
         <%} %>
    </div>
    <div class="cart-buttons">
    	
    	
		<a href="Menu?restaurantId=<%=session.getAttribute("restaurantId")%>"
		class="btn add-more-items-btn">Add More Items</a>
		
		<%
		if (session.getAttribute("cart") != null) {
		%>
		<form action="checkout.jsp" method="post">
        	<input type="submit" value="Proceed to Checkout" class="proceed-to-checkout-btn">
    	</form>
		<%
		}
		%>
    	
    </div>

</body>
</html>
