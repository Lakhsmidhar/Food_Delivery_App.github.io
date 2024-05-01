<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.foodDelivery.Models.Restaurant" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="RestaurantStyle.css">
    <link href="https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css" rel="stylesheet">
    <title>Restaurants</title>
</head>
<body>
    <div class="welcome-container">
        <h1 class="welcome-title">WELCOME TO FOOBANG</h1>
    </div>
    <div class="restaurant-card-container">
    <% List<Restaurant> list = (List<Restaurant>)request.getAttribute("restList");
       for (Restaurant res : list) { %>
        <div class="restaurant-card">
        	<a href="Menu?restaurantId=<%= res.getRestaurantID() %>"> 
            <div class="restaurant-image-container">
                <img src="<%= res.getImagePath() %>" alt="Restaurant image" class="restaurant-image">
            </div>
            <div class="restaurant-content-container">
                <div class="restaurant-info">
                    <h2 class="restaurant-name"><%= res.getName() %></h2>
                    <p class="restaurant-CuisineType"><%= res.getCuisineType() %></p>
                    <p class="restaurant-address"><%= res.getAddress() %></p>
                </div>
                <div class="restaurant-details">
                    <div class="restaurant-rating">
                        <span class="restaurant-rating-value"><%= res.getRating() %></span>
                        <i class='bx bxs-star'></i>
                    </div>
                    <div class="restaurant-DeliveryTime"><%= res.getDeliveryTime() %> min</div>
                </div>
            </div>
        </div>
    <% } %>
    </div>
</body>
</html>
