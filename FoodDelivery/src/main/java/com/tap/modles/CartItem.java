package com.tap.modles;

public class CartItem {

    int itemId;
    String name;
    double price;   
    int quantity;
    int restaurantId;
    double totalPrice; 

    
    
    public CartItem() {}

    
    
    public CartItem(int itemId, int restaurantId, String name, int quantity, double price) {
        this.itemId = itemId;
        this.restaurantId = restaurantId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    
    
    public double getTotalPrice() {
        return quantity * price;
    }

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	
	
	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", restaurantId=" + restaurantId + ", totalPrice=" + totalPrice + "]";
	}
    
    
    

	
	
}
