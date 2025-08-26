package default1;

import java.util.Scanner;
import java.util.ArrayList;
import com.tap.Daoimpl.OrderImpl;
import com.tap.dao1.OrderDao;
import com.tap.modles.Order;

public class OrderLaunch {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter the orderId");
		int oid = sc.nextInt();
//		System.out.println("Enter the userId");
//		int uid = sc.nextInt();
//		System.out.println("Enter the restaurantId");
//		int rid = sc.nextInt();
//		System.out.println("Enter the totalAmount");
//		Double totalamount = sc.nextDouble();
//		System.out.println("Enter the status");
//    	String status = sc.next();
//		System.out.println("Enter the paymentMethod");
//		String payMethod = sc.next();
//		
//		
//		Order or = new Order(oid, uid, rid, totalamount, status, payMethod);
		
//		OrderDao impl = new OrderImpl();
//		impl.insertOrder(or);
		
//		OrderDao impl = new OrderImpl();
//		impl.deleteOrder(oid);
		
//		OrderDao impl = new OrderImpl();
//		List<Order> list = impl.getAllOrders();
//		
//		for(Order order : list)
//		{
//			System.out.println(order);
//		}
        
        
		
		OrderDao impl = new OrderImpl();
		Order order = impl.getOrderById(oid); 
		order.setTotalAmount(100); 
		impl.updateOrderStatus(order);
}
}
