package com.tap.dao1;

import java.util.List;

import com.tap.modles.Order;

public interface OrderDao {
	int insertOrder(Order order) ;

    Order getOrderById(int id) ;

    List<Order> getAllOrders() ;

    void updateOrderStatus(Order order) ;

    void deleteOrder(int id) ;
}
