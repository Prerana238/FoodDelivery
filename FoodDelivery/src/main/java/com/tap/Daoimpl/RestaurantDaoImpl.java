package com.tap.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao1.RestaurantDao;
import com.tap.modles.Restaurant;
import com.tap.util.DBconnection;

public class RestaurantDaoImpl implements RestaurantDao{

	private String INSERT="INSERT into `Restaurant` (`RestaurantId` , `Name`, `Address`, `Phone` , `Rating`, `CuisineType`, `IsActive`, `Eta` , `AdminUserId`, `ImagePath`) values (?,?,?,?,?,?,?,?,?,?)";
	private String Get_RESTAURANT="SELECT * from `Restaurant` where `RestaurantId`=? ";
	private String UPDATE_RESTAURANT = "UPDATE `Restaurant` SET  `Name`=?, `Address`=?, `Phone`=? , `Rating`=?, `CuisineType`=?, `IsActive`=?, `Eta`=? , `AdminUserId`=?, `ImagePath`=? where `RestaurantId`=?";
	private String DELETE_RESTAURANT = "Delete from `Restaurant` where `RestaurantId` = ?";
	private String Get_ALL_RESTAURANT="Select * from `Restaurant`";
	Restaurant rest;
	@Override
	public void addRestaurant(Restaurant restaurant) {
		
		try {
			Connection con = DBconnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT );
		
			pstmt.setInt(1, restaurant.getRestaurantId());
			pstmt.setString(2, restaurant.getName());
			pstmt.setString(3, restaurant.getAddress());
			pstmt.setString(4, restaurant.getPhone());
			pstmt.setString(5, restaurant.getRating());
			pstmt.setString(6, restaurant.getCuisineType());
			pstmt.setBoolean(7, restaurant.getIsActive());
			pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(9, restaurant.getAdminUserId());
			pstmt.setString(10, restaurant.getImagePath());
			
			int res = pstmt.executeUpdate();
			
			System.out.println(res);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
		
	@Override
	public Restaurant getRestaurant(int id) {
        Connection con = DBconnection.getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(Get_RESTAURANT );
			
			pstmt.setInt(1, id);
			
			ResultSet res =  pstmt.executeQuery();
			
			while(res.next()) {
				int rid = res.getInt(1);
				String name = res.getString(2);
				String address = res.getString(3);
				String phone = res.getString(4);
				String rating = res.getString(5);
				String cusinetype = res.getString(6);
				Boolean isActive = res.getBoolean(7);
				Timestamp eta = res.getTimestamp(8);
				int adminuserid = res.getInt(9);
				String imagepath = res.getString(10);
				
				rest  = new Restaurant(rid, name, address, phone, rating, cusinetype, isActive, eta, adminuserid, imagepath);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rest;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		Connection con = DBconnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(UPDATE_RESTAURANT  );
			
		
			pstmt.setString(1, restaurant.getName());
			pstmt.setString(2, restaurant.getAddress());
			pstmt.setString(3, restaurant.getPhone());
			pstmt.setString(4, restaurant.getRating());
			pstmt.setString(5, restaurant.getCuisineType());
			pstmt.setBoolean(6, restaurant.getIsActive());
			pstmt.setTimestamp(7, restaurant.getEta());
			pstmt.setInt(8, restaurant.getAdminUserId());
			pstmt.setString(9, restaurant.getImagePath());
			pstmt.setInt(10, restaurant.getRestaurantId());
			int res = pstmt.executeUpdate();
			
			System.out.println(res);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void deleteRestaurant(int id) {
    Connection con = DBconnection.getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(DELETE_RESTAURANT  );
			
			pstmt.setInt(1, id);
			
		int res = pstmt.executeUpdate();
			
		System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
  Connection con = DBconnection.getConnection();
		
		List<Restaurant> list = new ArrayList<Restaurant>();
Restaurant rest = new Restaurant();
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement(Get_ALL_RESTAURANT );
			
			ResultSet res =  pstmt.executeQuery();
			
			while(res.next()) {
				int rid = res.getInt(1);
				String name = res.getString(2);
				String address = res.getString(3);
				String phone = res.getString(4);
				String rating = res.getString(5);
				String cusinetype = res.getString(6);
				Boolean isActive = res.getBoolean(7);
				Timestamp eta = res.getTimestamp(8);
				int adminuserid = res.getInt(9);
				String imagepath = res.getString(10);
				
				rest  = new Restaurant(rid, name, address, phone, rating, cusinetype, isActive, eta, adminuserid, imagepath);
				list.add(rest);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	
		}
		}	
	


