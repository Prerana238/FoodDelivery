package com.tap.servlets;

import java.io.IOException;
import java.util.List;
import com.tap.Daoimpl.RestaurantDaoImpl;
import com.tap.dao1.RestaurantDao;
import com.tap.modles.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("Getting All Restaurants!!!");
		RestaurantDaoImpl rest;
		try {
			rest = new RestaurantDaoImpl();
			List<Restaurant> allRestaurant = rest.getAllRestaurants(); 
			request.setAttribute("restaurants", allRestaurant);
			RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/Restaurant1.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
