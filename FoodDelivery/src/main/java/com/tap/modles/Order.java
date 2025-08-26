package com.tap.modles;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Order {
	
	    private int orderId;
	    private int userId;
	    private int restaurantId;
	    private Timestamp orderDate;
	    private double totalAmount;
	    private String status;
	    private String paymentMode;
	    private String address;
	 //   private List<OrderItem> orderItems;

	   public Order() {;
		   
	   }

	
	
	
	public Order(int orderId, int userId, int restaurantId, double totalAmount, String status, String paymentMode,String address) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
		this.address=address;
	}

	public Order(int orderId, int userId, int restaurantId, Timestamp orderDate, double totalAmount, String status, String paymentMode) {
	    this.orderId = orderId;
	    this.userId = userId;
	    this.restaurantId = restaurantId;
	    this.orderDate = orderDate;
	    this.totalAmount = totalAmount;
	    this.status = status;
	    this.paymentMode = paymentMode;
	}

	public Order(int orderId, int userId, int restaurantId, Timestamp orderDate, double totalAmount, String status, String paymentMode, String address) {
	    this.orderId = orderId;
	    this.userId = userId;
	    this.restaurantId = restaurantId;
	    this.orderDate = orderDate;
	    this.totalAmount = totalAmount;
	    this.status = status;
	    this.paymentMode = paymentMode;
	    this.address = address;
	}

	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate ) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	 public String getaddress() {
			return address;
		}
		 public void setAddress(String address) {
			this.address = address;
		 }

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", orderDate="
				+ orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", paymentMode=" + paymentMode
				+ ", address=" + address + "]";
	}
	   
	   
	   
	   
	   
}

