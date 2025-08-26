package com.tap.servlets;

import java.io.IOException;

import com.tap.Daoimpl.userDaoImpl;
import com.tap.modles.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName= request.getParameter("username");
		String password= request.getParameter("password");
		userDaoImpl impl = new userDaoImpl();
		user user=impl.checkLogin(userName, password); 
		HttpSession session = request.getSession();
				
		if(user != null) {
			
			System.out.println("Login Succesfully");
		
			session.setAttribute("username", user.getUserName());
			session.setAttribute("user", user);
			response.sendRedirect("Home");

		
		}
		else {
			System.out.println("Invalid User Name or Password");
			request.setAttribute("error", "Invalid username or password");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}