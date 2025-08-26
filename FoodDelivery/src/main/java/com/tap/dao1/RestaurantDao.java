package com.tap.dao1;

import java.util.List;

import com.tap.modles.Restaurant;

public interface RestaurantDao {

	void addRestaurant(Restaurant restaurant);
	Restaurant getRestaurant(int id);
	void updateRestaurant(Restaurant restaurant);
	void deleteRestaurant(int id);
	List<Restaurant>getAllRestaurants();
	
	
	
	
	
	
	
}
