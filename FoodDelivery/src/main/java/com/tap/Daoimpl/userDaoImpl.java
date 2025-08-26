package com.tap.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import com.tap.dao1.userDao;
import com.tap.modles.user;
import com.tap.util.DBconnection;

public class userDaoImpl implements userDao{

	
	private String INSERT = "INSERT INTO `user` (`Name`, `UserName`, `Password`, `Email`, `PhoneNumber`, `Address`, `Role`, `CreateDate`, `LastLoginDate`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";;
	private String Get_USER = "SELECT * from `user` where `UserId`=? ";
	private String UPDATE = "UPDATE `user` SET `Name`=?, `UserName`=?, `Password`=?, `Email`=?, `PhoneNumber`=?, `Address`=?, `Role`=?, `LastLoginDate`=? WHERE `UserId`=?";
	private String GET_ALL_USER = "Select * from `user`";
	private String DELETE = "Delete from `user` where `UserId` = ?";
	private String CHECK_LOGIN="SELECT * FROM `user` WHERE `UserName`=? AND `Password`=?";

	user user=new user();

	@Override
	public void adduser(user user) {
	    String sql = "INSERT INTO `user` (`Name`, `UserName`, `Password`, `Email`, `PhoneNumber`, `Address`, `Role`, `CreateDate`, `LastLoginDate`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    try (Connection con = DBconnection.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(INSERT)) {

	        pstmt.setString(1, user.getName());
	        pstmt.setString(2, user.getUserName());
	        pstmt.setString(3, user.getPassword());
	        pstmt.setString(4, user.getEmail());
	        pstmt.setString(5, user.getPhoneNumber());
	        pstmt.setString(6, user.getAddress());
	        pstmt.setString(7, user.getRole());
	        pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis())); // CreateDate
	        pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis())); // LastLoginDate

	        int rows = pstmt.executeUpdate();

	        if (rows > 0) {
	            System.out.println("✅ User added successfully!");
	        } else {
	            System.out.println("❌ Failed to add user!");
	        }

	    } catch (SQLException e) {
	        System.err.println("Error while adding user: " + e.getMessage());
	        e.printStackTrace();
	    }
	}


	@Override
	public void updateuser(user user) {
	    try (Connection con = DBconnection.getConnection();
	         PreparedStatement pstmt = con.prepareStatement(UPDATE)) {

	        pstmt.setString(1, user.getName());
	        pstmt.setString(2, user.getUserName());
	        pstmt.setString(3, user.getPassword());
	        pstmt.setString(4, user.getEmail());
	        pstmt.setString(5, user.getPhoneNumber());
	        pstmt.setString(6, user.getAddress());
	        pstmt.setString(7, user.getRole()); // Added Role here
	        pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis())); // LastLoginDate
	        pstmt.setInt(9, user.getUserid());

	        int res = pstmt.executeUpdate();
	        System.out.println("Rows updated: " + res);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void deleteuser(int id) {
		Connection con = DBconnection.getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(DELETE );
			
			pstmt.setInt(1, id);
			
		int res = pstmt.executeUpdate();
			
		System.out.println(res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public user getuser(int id) {
		Connection con = DBconnection.getConnection();
		
		user user = new user();
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement(Get_USER );
			
			pstmt.setInt(1, id);
			
			ResultSet res =  pstmt.executeQuery();
			
			while(res.next()) {
				int uid= res.getInt(1);
				String name=res.getString(2);
				String userName=res.getString(3);
				String password=res.getString(4);
				String email=res.getString(5);
				String phoneNumber=res.getString(6);
				String address=res.getString(7);
				String role=res.getString(8);
				Timestamp createDate=res.getTimestamp(9);
				Timestamp loginDate= res.getTimestamp(10);
				user=new user(uid,name, userName, password, email, phoneNumber, address, role, createDate, loginDate);


			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}


	@Override
	public List<user> getallusers() {
		
		Connection con = DBconnection.getConnection();
		
		List<user> list = new ArrayList<user>();
		user user;
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement(GET_ALL_USER );
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int uid= res.getInt(1);
				String name=res.getString(2);
				String userName=res.getString(3);
				String password=res.getString(4);
				String email=res.getString(5);
				String phoneNumber=res.getString(6);
				String address=res.getString(7);
				String role=res.getString(8);
				Timestamp createDate=res.getTimestamp(9);
				Timestamp loginDate= res.getTimestamp(10);
				user=new user(uid,name, userName, password, email, phoneNumber, address, role, createDate, loginDate);
				list.add(user);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return list;
	}

	
	@Override
	public user checkLogin(String username, String password) {
		user=null;
		
		Connection con = DBconnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(CHECK_LOGIN);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet res = pstmt.executeQuery();
			if(res.next()) {
				user=new user();
				user.setUserid(res.getInt(1));
				user.setName(res.getString(2));
				user.setUserName(res.getString(3));
				user.setPassword(res.getString(4));
				user.setEmail(res.getString(5));
				user.setPhoneNumber(res.getString(6));
				user.setAddress(res.getString(7));
				user.setRole(res.getString(8));
				user.setCreateDate(res.getTimestamp(9));
				user.setLastLoginDate(res.getTimestamp(10));
				
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
	}
}
