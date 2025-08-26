package com.tap.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao1.MenuDao;
import com.tap.modles.Menu;
import com.tap.modles.Restaurant;
import com.tap.modles.user;
import com.tap.util.DBconnection;

public class MenuImpl implements MenuDao{

	private String INSERT_MENU = "INSERT into `Menu` (`MenuId` , `RestaurantId`, `ItemName`, `Description` , `Price`, `Ratings`, `IsAvailable`, `ImagePath`) values (?,?,?,?,?,?,?,?)";
	private String Get_MENU="SELECT * from `Menu` where `MenuId`=? ";
	private String UPDATE_MENU = "UPDATE `Menu` SET `RestaurantId`=?, `ItemName`=? , `Description`=?, `Price`=?, `Ratings`=?, `IsAvailable`=? , `ImagePath`=? where `MenuId`=?";
	private String DELETE_MENU = "Delete from `Menu` where `MenuId` = ?";
	private String Get_ALL_MENU="SELECT * FROM `Menu` WHERE `RestaurantId`=?";;
	Menu mn ;
	

	@Override
	public void addMenuItem(Menu menuItem) {
		try {
			Connection con = DBconnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(INSERT_MENU  );
		
			pstmt.setInt(1, menuItem.getMenuId());
			pstmt.setInt(2, menuItem.getRestaurantId());
			pstmt.setString(3, menuItem.getItemName());
			pstmt.setString(4, menuItem.getDescription());
			pstmt.setDouble(5, menuItem.getPrice());
			pstmt.setInt(6, menuItem.getRatings());
			pstmt.setString(7, menuItem.getIsAvailable());
			pstmt.setString(8, menuItem.getImagePath());
			
			int res = pstmt.executeUpdate();
			
			System.out.println(res);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	@Override
	public Menu getMenuItemById(int id) {
Connection con = DBconnection.getConnection();

		try {
			PreparedStatement pstmt = con.prepareStatement(Get_MENU );
			
			pstmt.setInt(1, id);
			
			ResultSet res =  pstmt.executeQuery();
			
			while(res.next()) {
				int menuid = res.getInt(1);
				int restid = res.getInt(2);
				String itemName = res.getString(3);
				String description = res.getString(4);
				Double price = res.getDouble(5);
				int ratings = res.getInt(6);
				String isavailable = res.getString(7);
				String imagepath = res.getString(8);
				mn  = new Menu(menuid, restid, itemName, description, price, ratings, isavailable, imagepath);
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mn;
		
	}

	@Override
	public List<Menu> getAllMenuItems(int restaurantId) {
	    Connection con = DBconnection.getConnection();
	    List<Menu> list = new ArrayList<>();

	    try {
	        PreparedStatement pstmt = con.prepareStatement(Get_ALL_MENU);
	        pstmt.setInt(1, restaurantId);   // ✅ set the parameter

	        ResultSet res = pstmt.executeQuery();

	        while (res.next()) {
	            int menuid = res.getInt(1);
	            int restid = res.getInt(2);
	            String itemName = res.getString(3);
	            String description = res.getString(4);
	            Double price = res.getDouble(5);
	            int ratings = res.getInt(6);
	            String isavailable = res.getString(7);
	            String imagepath = res.getString(8);

	            Menu mn = new Menu(menuid, restid, itemName, description, price, ratings, isavailable, imagepath);
	            list.add(mn);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return list;
	}


	@Override
	public void updateMenuItem(Menu menuItem) {
		try {
			Connection con = DBconnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(UPDATE_MENU  );
		
			pstmt.setInt(1, menuItem.getRestaurantId());
			pstmt.setString(2, menuItem.getItemName());
			pstmt.setString(3, menuItem.getDescription());
			pstmt.setDouble(4, menuItem.getPrice());
			pstmt.setInt(5, menuItem.getRatings());
			pstmt.setString(6, menuItem.getIsAvailable());
			pstmt.setString(7, menuItem.getImagePath());
			pstmt.setInt(8, menuItem.getMenuId());
			
			int res = pstmt.executeUpdate();
			
			System.out.println(res);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteMenuItem(int id) {
Connection con = DBconnection.getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(DELETE_MENU   );
			
			pstmt.setInt(1, id);
			
		int res = pstmt.executeUpdate();
			
		System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	
		
	

}
