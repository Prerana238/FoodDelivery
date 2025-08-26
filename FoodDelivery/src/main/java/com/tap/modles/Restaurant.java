package com.tap.modles;

import java.sql.Timestamp;

public class Restaurant {

	
	private int restaurantId;
    private String name;
    private String address;
    private String phone;
    private String rating;
    private String cuisineType;
    private Boolean isActive;
    private Timestamp eta;
    private int adminUserId;
    private String imagePath;
    
    
    public Restaurant() {}


	public Restaurant(int restaurantId, String name, String address, String phone, String rating, String cuisineType,
			Boolean isActive, Timestamp eta, int adminUserId, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
		this.cuisineType = cuisineType;
		this.isActive = isActive;
		this.eta = eta;
		this.adminUserId = adminUserId;
		this.imagePath = imagePath;
		
	}
	
	
	
	


	


	public Restaurant(int restaurantId, String name, String address, String phone, String rating, String cuisineType,
			Boolean isActive, int adminUserId, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
		this.cuisineType = cuisineType;
		this.isActive = isActive;
		this.adminUserId = adminUserId;
		this.imagePath = imagePath;
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getCuisineType() {
		return cuisineType;
	}


	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public Timestamp getEta() {
		return eta;
	}


	public void setEta(Timestamp eta) {
		this.eta = eta;
	}


	public int getAdminUserId() {
		return adminUserId;
	}


	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", rating=" + rating + ", cuisineType=" + cuisineType + ", isActive=" + isActive + ", eta="
				+ eta + ", adminUserId=" + adminUserId + ", imagePath=" + imagePath + "]";
	}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
