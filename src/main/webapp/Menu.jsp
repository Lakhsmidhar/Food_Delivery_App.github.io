<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.foodDelivery.Models.Menu, com.foodDelivery.Models.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
    <link rel="stylesheet" href="MenuStyle.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@4.2.0/fonts/remixicon.css" rel="stylesheet">
   
</head>
<body>
    <div class="banner-container">
        <img src="https://images.unsplash.com/photo-1501353163335-102e39d92607?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Banner Image" class="banner-image">
    </div>
    <div class="restaurant-details-box">
        <h1 class="restaurant-name"><%=((Restaurant)request.getAttribute("restList")).getName()%></h1>
        <p class="restaurant-description"><%=((Restaurant)request.getAttribute("restList")).getCuisineType()%></p>
        <p class="restaurant-location"><%=((Restaurant)request.getAttribute("restList")).getAddress()%></p>
        <i id="star" class="ri-star-smile-fill"></i>
        <p id="rate" class="restaurant-rating"><%=((Restaurant)request.getAttribute("restList")).getRating()%></p>
    </div>
    <div class="menu-container">
        <%
            List<Menu> menuList = (List<Menu>)request.getAttribute("menuList");
            for(Menu menu : menuList){
        %>
        <div class="menu-item">
            <img src="<%= menu.getImgPath()%>" alt="Food Image" class="item-image">
            <div class="item-details">
                <h2 class="item-name"><%=menu.getItemName()%></h2>
                <p class="item-description"><%=menu.getDescription()%></p>
                <p class="item-price">$ <%=menu.getPrice()%></p>
            </div>
            <form action="cart" method="post">
                <div class="quantity">
                    <button type="button" onclick="decrementQuantity(this)">-</button>
                    <input type="text" class="quantity-input" name="quantity" value="1" min="1">
                    <button type="button" onclick="incrementQuantity(this)">+</button>
                </div>
	            <input type="hidden" name="itemId" value="<%= menu.getMenuID()%>">
	            <input type="hidden" name="action" value="add">
	            <button type="submit" class="add-to-cart-btn">Add to Cart</button>
        	</form>
        </div>
        <% } %>
    </div>
    <script>
        function incrementQuantity(element) {
            var input = element.parentElement.querySelector('.quantity-input');
            var value = parseInt(input.value, 10);
            input.value = value + 1;
        }

        function decrementQuantity(element) {
            var input = element.parentElement.querySelector('.quantity-input');
            var value = parseInt(input.value, 10);
            if (value > 1) {
                input.value = value - 1;
            }
        }

    </script>
</body>
</html>
