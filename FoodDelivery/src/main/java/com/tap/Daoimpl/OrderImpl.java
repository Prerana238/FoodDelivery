package com.tap.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.modles.Order;
import com.tap.util.DBconnection;
import com.tap.dao1.OrderDao;


public class OrderImpl implements OrderDao {

    private String INSERT = "INSERT INTO `order` (`UserId`, `restaurantId`, `orderDate`, `totalAmount`, `status`, `paymentMode`, `address`) VALUES (?,?,?,?,?,?,?)";
    private String UPDATE = "UPDATE `order` SET `UserId`=?, `restaurantId`=?, `orderDate`=?, `totalAmount`=?, `status`=?, `paymentMode`=?, `address`=? WHERE `orderId`=?";
    private String DELETE = "DELETE FROM `order` WHERE `orderId`=?";
    private String GET_ORDER_BY_ID = "SELECT * FROM `order` WHERE `orderId`=?";
    private String GET_ALL_ORDER = "SELECT * FROM `order`";

    Order order;

    @Override
    public int insertOrder(Order order) {
        int orderId = 0;
        try (Connection con = DBconnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, order.getUserId());
            pstmt.setInt(2, order.getRestaurantId());
            pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis())); // Current time as order date
            pstmt.setDouble(4, order.getTotalAmount());
            pstmt.setString(5, order.getStatus());
            pstmt.setString(6, order.getPaymentMode());
            pstmt.setString(7, order.getaddress());
            int res = pstmt.executeUpdate();
            System.out.println("Rows Inserted: " + res);

            ResultSet keys = pstmt.getGeneratedKeys();
            while (keys.next()) {
                orderId = keys.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderId;
    }

    @Override
    public Order getOrderById(int id) {
        try {
        	Connection con = DBconnection.getConnection();
        
             PreparedStatement pstmt = con.prepareStatement(GET_ORDER_BY_ID) ;
            		 

             pstmt.setInt(1, id);
             ResultSet res = pstmt.executeQuery();
             while(res.next()){
                int oid = res.getInt("orderId");
                int userId = res.getInt("UserId");
                int restaurantId = res.getInt("restaurantId");
                Timestamp orderDate = res.getTimestamp("orderDate");
                double totalAmount = res.getDouble("totalAmount");
                String status = res.getString("status");
                String paymentMode = res.getString("paymentMode");
                String address=res.getString(8);
                order = new Order(oid, userId, restaurantId, orderDate, totalAmount, status, paymentMode,address);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
	public List<Order> getAllOrders() {
		List<Order> li=new ArrayList<Order>();
		
		try {
			Connection con = DBconnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(GET_ALL_ORDER);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int oid=res.getInt(1);
				int userId=res.getInt(2);
				int restaurantId=res.getInt(3);
				Timestamp orderDate=res.getTimestamp(4);
				int totalAmount=res.getInt(5);
				String status=res.getString(6);
				String paymentMode=res.getString(7);
				String address=res.getString(8);
				order =new Order(oid, userId, restaurantId, orderDate, totalAmount, status, paymentMode,address);			
				li.add(order);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
	}

    @Override
    public void updateOrderStatus(Order order) {
        try (Connection con = DBconnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(UPDATE)) {

            pstmt.setInt(1, order.getUserId());
            pstmt.setInt(2, order.getRestaurantId());
            pstmt.setTimestamp(3, order.getOrderDate()); // Use existing order date
            pstmt.setDouble(4, order.getTotalAmount());
            pstmt.setString(5, order.getStatus());
            pstmt.setString(6, order.getPaymentMode());
            pstmt.setString(7, order.getaddress());
            pstmt.setInt(8, order.getOrderId());

            int res = pstmt.executeUpdate();
            System.out.println("Rows Updated: " + res);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int id) {
        try (Connection con = DBconnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(DELETE)) {

            pstmt.setInt(1, id);
            int res = pstmt.executeUpdate();
            System.out.println("Rows Deleted: " + res);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
