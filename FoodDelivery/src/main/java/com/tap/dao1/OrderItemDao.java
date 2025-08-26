package com.tap.dao1;


import java.util.List;

import com.tap.modles.OrderItem;

public interface OrderItemDao {

	void insertOrderItem(OrderItem orderItem) ;

    OrderItem getOrderItemById(int id) ;

    List<OrderItem> getAllOrderItems() ;

    void updateQuantityAndPrice(OrderItem orderItem) ;

    void deleteOrderItem(int id) ;
}
