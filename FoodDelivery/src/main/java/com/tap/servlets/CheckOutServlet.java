package com.tap.servlets;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import com.tap.dao1.OrderDao;
import com.tap.Daoimpl.Cart;
import com.tap.Daoimpl.OrderItemImpl;
import com.tap.Daoimpl.OrderImpl;
import com.tap.modles.CartItem;
import com.tap.modles.Order;
import com.tap.modles.OrderItem;
import com.tap.modles.user;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {
	private OrderDao orderDao;
	private OrderItemImpl orderItemDAOImpl = new OrderItemImpl();;

	@Override
		public void init() throws ServletException {
		try {
			orderDao = new OrderImpl();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("Failed to start Order DAO Impl",e);
		}
			
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Checkout sevlet is called");
		
		
		HttpSession session = request.getSession();
		
		Cart cart=(Cart) session.getAttribute("cart");
		user user=(user) session.getAttribute("user");
		
		
		
		
		if(cart != null && user!=null && !cart.getItems().isEmpty()) {
			
			// Extract from Data
			String paymentMethod = request.getParameter("paymentMethod");
			String address = request.getParameter("address");
			
			//create and populate order object
			Order order= new Order();
			

			order.setUserId(user.getUserid());
			order.setRestaurantId( (int)session.getAttribute("restaurantId"));
			order.setOrderDate(new Timestamp(new Date().getTime()));
			order.setPaymentMode(paymentMethod);
			order.setAddress(address);
			order.setStatus("Pending");
			
	
			
			//calculate total AMount
			double totalAmount=0;
			for(CartItem item: cart.getItems().values()) {
				totalAmount+=item.getPrice()*item.getQuantity();
			}
			order.setTotalAmount(totalAmount);
			
			
			OrderDao orderDao = new OrderImpl();
			int orderId = orderDao.insertOrder(order);
			
			
			for(CartItem item: cart.getItems().values()) {
				OrderItem oi = new OrderItem();
				int itemId = item.getItemId();
				String name = item.getName();
				double price = item.getPrice();
				int quantity = item.getQuantity();
				double totalPrice= price*quantity;
				
			
				OrderItem orderItem = new OrderItem(orderId,itemId, quantity, totalPrice);
				OrderItemImpl orderItemDao = new OrderItemImpl();
				orderItemDao.insertOrderItem(orderItem);

				
				
				
			}
			
			
			session.setAttribute("order", order);
			RequestDispatcher rd = request.getRequestDispatcher("order_confirmation.jsp");
			rd.forward(request, response);
			//session.removeAttribute("cart");
		}
		else {
			if(user==null) {
				 response.sendRedirect("login.jsp");
				 return;
			}
			response.sendRedirect("cart.jsp");
		}
		
		
		
		
	}

}
