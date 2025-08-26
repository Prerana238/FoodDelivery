package com.tap.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import com.tap.Daoimpl.userDaoImpl;
import com.tap.modles.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // 1. Get form data
            String name = request.getParameter("fullName");
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String phoneNumber = request.getParameter("phone");
            String address = request.getParameter("address");
            String role = request.getParameter("role"); // Optional field

            // 2. Create User object
            user user = new user();
            user.setName(name);
            user.setUserName(userName);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            user.setAddress(address);
            user.setRole(role);
            user.setCreateDate(new Timestamp(System.currentTimeMillis()));
            user.setLastLoginDate(new Timestamp(System.currentTimeMillis()));

            // 3. Add user using DAO
            userDaoImpl impl = new userDaoImpl();
            impl.adduser(user);

            // 4. Redirect or show message
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);

            System.out.println("New User added Successfully!!!");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error while signing up.");
        }
    }
}
