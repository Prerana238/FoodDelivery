package com.tap.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

	private static String URL = "jdbc:mysql://localhost:3306/dao";
	private static String USERNAME = "root";
	private static String PASSWORD = "coader";
	private static Connection con;
	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		  con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
		
		return con;
		
	}
}