<%@page import="org.apache.tomcat.util.descriptor.web.LoginConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.foodDelivery.Models.Restaurant" %>   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FooBang - Food Delivery</title>
    <link rel="stylesheet" type="text/css" href="RestaurantStyle.css">
</head>
<body>
    <div class="landing-container">
        <h1>Welcome to FooBang</h1>
        <%
        
	    List<Restaurant> list = (List<Restaurant>)request.getAttribute("restList");
		for(Restaurant res : list){
			
    	%>
    		<div>
    			<h3><%= res.getName()%>></h3>
    		</div>
    	<%	
    	}
      %> 
        <div class="restaurants">
	            <div class="restaurant" >
	                <img src="https://images.unsplash.com/photo-1658944220227-ecadbe15af79?q=80&w=1935&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Restaurant 1">
	                <div class="restaurant-info">
	                    <h2>Table 9</h2>
	                    <p>South Indian,North Indian,Chineese,Italian</p>
	                    <div class="rating">
	                        <span class="star"></span>
	                        <span class="star"></span>
	                        <span class="star"></span>
	                        <span class="star"></span>
	                        <span class="star"></span>
	                    </div>
	                    <p class="price">$$</p>
	                </div>
	            </div>
            <div class="restaurant">
                <img src="https://images.unsplash.com/photo-1649001484355-6c6ea7148c66?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Restaurant 1">
                <div class="restaurant-info">
                    <h2>Chillies</h2>
                    <p>South Indian,North Indian,Chineese,Italian</p>
                    <div class="rating">
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                    </div>
                    <p class="price">$$</p>
                </div>
            </div>
            <div class="restaurant">
                <img src="https://images.unsplash.com/photo-1582734073424-1cc142558946?q=80&w=1931&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Restaurant 1">
                <div class="restaurant-info">
                    <h2>BiryaniWala</h2>
                    <p>South Indian,North Indian,Chineese,Italian</p>
                    <div class="rating">
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                    </div>
                    <p class="price">$$</p>
                </div>
            </div>
            <div class="restaurant">
                <img src="https://images.unsplash.com/photo-1582734073424-1cc142558946?q=80&w=1931&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Restaurant 1">
                <div class="restaurant-info">
                    <h2>Behrouz Biryani</h2>
                    <p>South Indian,North Indian,Chineese,Italian</p>
                    <div class="rating">
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                    </div>
                    <p class="price">$$</p>
                </div>
            </div>
            <div class="restaurant">
                <img src="https://images.unsplash.com/photo-1628678223366-c0669ef47ac1?q=80&w=1854&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Restaurant 1">
                <div class="restaurant-info">
                    <h2>Domino's Pizza</h2>
                    <p>South Indian,North Indian,Chineese,Italian</p>
                    <div class="rating">
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                    </div>
                    <p class="price">$$</p>
                </div>
            </div>
            <div class="restaurant">
                <img src="https://images.unsplash.com/photo-1658944220227-ecadbe15af79?q=80&w=1935&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Restaurant 1">
                <div class="restaurant-info">
                    <h2>Star Biryani</h2>
                    <p>South Indian,North Indian,Chineese,Italian</p>
                    <div class="rating">
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                    </div>
                    <p class="price">$$</p>
                </div>
            </div>
            <div class="restaurant">
                <img src="https://images.unsplash.com/photo-1658944220227-ecadbe15af79?q=80&w=1935&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Restaurant 1">
                <div class="restaurant-info">
                    <h2>FB Cakes</h2>
                    <p>South Indian,North Indian,Chineese,Italian</p>
                    <div class="rating">
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                    </div>
                    <p class="price">$$</p>
                </div>
            </div>
            <div class="restaurant">
                <img src="https://images.unsplash.com/photo-1474899420076-a61e74989430?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Restaurant 1">
                <div class="restaurant-info">
                    <h2>Kwality Walls</h2>
                    <p>South Indian,North Indian,Chineese,Italian</p>
                    <div class="rating">
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                    </div>
                    <p class="price">$$</p>
                </div>
            </div>
            <div class="restaurant">
                <img src="https://images.unsplash.com/photo-1628678223366-c0669ef47ac1?q=80&w=1854&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="Restaurant 1">
                <div class="restaurant-info">
                    <h2>Cream Stone</h2>
                    <p>South Indian,North Indian,Chineese,Italian</p>
                    <div class="rating">
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                        <span class="star"></span>
                    </div>
                    <p class="price">$$</p>
                </div>
            </div>
            <!-- Repeat for other restaurants -->
            <!-- Include 9 restaurants -->
        </div>
    </div>
</body>
</html>
