package com.tap.modles;

import java.sql.Timestamp;

public class user {

	private int userid;
	private String name;
	private String username;
	private String password;
	private String email;
	private String phoneNumber;
	private String address;
	private String role;
	private Timestamp createDate;
	private Timestamp lastLoginDate;
	
	public user()
	{
		
	}


	public user(int userid, String name, String username, String password, String email, String phoneNumber,
			String address, String role, Timestamp createDate, Timestamp lastLoginDate) {
		super();
		this.userid = userid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
		this.createDate = createDate;
		this.lastLoginDate = lastLoginDate;
	}

	
	public user(String name, String username, String password, String email, String phoneNumber, String address,
			String role, Timestamp createDate, Timestamp lastLoginDate) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
		this.createDate = createDate;
		this.lastLoginDate = lastLoginDate;
	}


	

	public user(String name, String username, String password, String email, String phoneNumber, String address,
			String role) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUserName() {
		return username;
	}


	public void setUserName(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public Timestamp getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}


	public Timestamp getLastLoginDate() {
		return lastLoginDate;
	}


	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}


	@Override
	public String toString() {
		return "user [userid=" + userid + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", role=" + role
				+ ", createDate=" + createDate + ", lastLoginDate=" + lastLoginDate + "]";
	}


	

	
	
	
	
	
}
