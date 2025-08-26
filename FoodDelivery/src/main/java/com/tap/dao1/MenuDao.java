package com.tap.dao1;

import java.util.List;

import com.tap.modles.Menu;

public interface MenuDao {
	
	 void addMenuItem(Menu menuItem);

	    Menu getMenuItemById(int id);
	    List<Menu> getAllMenuItems(int restaurantId);

	    
	    void updateMenuItem(Menu menuItem);

	    void deleteMenuItem(int id);

		
}

