package com.tap.servlets;

import java.io.IOException;
import java.util.List;

import com.tap.Daoimpl.MenuImpl;
import com.tap.modles.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/menu")
public class MenuServlet extends HttpServlet{

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Menu Servlet is called");
int rid=Integer.parseInt(request.getParameter("restaurantId"));
System.out.println("Restaurant Id :"+rid);

try {
	MenuImpl doaImpl = new MenuImpl();
	
	List<Menu> menuList = doaImpl.getAllMenuItems(rid);
	request.setAttribute("menus", menuList);


//	
		RequestDispatcher rd = request.getRequestDispatcher("menu1.jsp");
        rd.forward(request, response);
} catch (Exception e) {
	
	e.printStackTrace();
}
}
}
