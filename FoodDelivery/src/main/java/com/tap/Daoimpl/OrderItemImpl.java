package com.tap.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao1.OrderItemDao;
import com.tap.modles.OrderItem;
import com.tap.util.DBconnection;

public class OrderItemImpl implements OrderItemDao {

	private String INSERT_ORDERITEM = "INSERT into `OrderItem` (`OrderItemId` , `OrderId`, `MenuId`, `Quantity` , `TotalAmount`) values (?,?,?,?,?)";
	OrderItem ordersItem;
	private String Get_ORDERITEM= "SELECT * from `OrderItem` where `OrderItemId`=? ";
	private String Update_ORDERITEM= "UPDATE `OrderItem` SET  `OrderId`=?, `MenuId`=? , `Quantity`=?, `TotalAmount`=? where `OrderItemId`=? ";
	private String DELETE_ORDERITEM = "DELETE FROM `OrderItem` WHERE `OrderItemId`=?";
	private String Get_ALL_ORDERITEM = "SELECT * FROM `OrderItem`";
	@Override
	public void insertOrderItem(OrderItem orderItem) {
		try {
			Connection con = DBconnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_ORDERITEM  );
		
			pstmt.setInt(1, orderItem.getOrderItemId());
			pstmt.setInt(2, orderItem.getOrderId());
			pstmt.setInt(3, orderItem.getMenuId());
			pstmt.setInt(4, orderItem.getQuantity());
			pstmt.setDouble(5, orderItem.getTotalAmount());
			
			int res = pstmt.executeUpdate();
			
			System.out.println(res);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public OrderItem getOrderItemById(int id) {
		 Connection con = DBconnection.getConnection();
			
			try {
				PreparedStatement pstmt = con.prepareStatement(Get_ORDERITEM );
				
				pstmt.setInt(1, id);
				
				ResultSet res =  pstmt.executeQuery();
				
				while(res.next()) {
					int oiid = res.getInt(1);
					int oid= res.getInt(2);
					int menuid = res.getInt(3);
					int quantity = res.getInt(4);
					double totalprice = res.getDouble(5);
					
					ordersItem = new OrderItem(oiid, oid, menuid, quantity, totalprice);	
					}
			
			
			
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ordersItem;
}


	@Override
	public List<OrderItem> getAllOrderItems() {
Connection con = DBconnection.getConnection();
		
		List<OrderItem> list = new ArrayList<OrderItem>();
		try {
			PreparedStatement pstmt = con.prepareStatement(Get_ALL_ORDERITEM  );
			
			ResultSet res =  pstmt.executeQuery();
			
			while(res.next()) {
				int oiid = res.getInt(1);
				int oid= res.getInt(2);
				int menuid = res.getInt(3);
				int quantity = res.getInt(4);
				double totalprice = res.getDouble(5);
				
				
				ordersItem = new OrderItem(oiid, oid, menuid, quantity, totalprice);	
				list.add(ordersItem);
				}
		
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return list;
		
	}
	

	@Override
	public void updateQuantityAndPrice(OrderItem orderItem) {
		
		Connection con = DBconnection.getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(Update_ORDERITEM );
			
			
			pstmt.setInt(1, orderItem.getOrderId());
			pstmt.setInt(2, orderItem.getMenuId());
			pstmt.setInt(3, orderItem.getQuantity());
			pstmt.setDouble(4, orderItem.getTotalAmount());
			pstmt.setInt(5, orderItem.getOrderItemId());
			
			int res = pstmt.executeUpdate();
			
			System.out.println(res);
			
		
		
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}
	
	

	@Override
	public void deleteOrderItem(int id) {
		
      Connection con = DBconnection.getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(DELETE_ORDERITEM   );
			
			pstmt.setInt(1, id);
			
		int res = pstmt.executeUpdate();
			
		System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}

	
		
	

