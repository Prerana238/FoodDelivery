package default1;
import java.util.List;
import java.util.Scanner;

import com.tap.Daoimpl.OrderItemImpl;
import com.tap.dao1.OrderItemDao;
import com.tap.modles.OrderItem;

public class OrderItemLaunch {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter the orderItemId");
		int oiid = sc.nextInt();
//		System.out.println("Enter the orderId");
//		int oid = sc.nextInt();
//		System.out.println("Enter the menuId");
//		int mid = sc.nextInt();
//		System.out.println("Enter the quantity");
//		int quantity= sc.nextInt();
//		System.out.println("Enter the totalamount");
//    	Double totalamount = sc.nextDouble();
//		
		
		
//		OrderItem rest = new OrderItem (oiid, oid, mid, quantity, totalamount);
		
//		OrderItemDao impl = new OrderItemImpl();
//		impl.insertOrderItem(rest);
		
//		OrderItemDao impl = new OrderItemImpl();
//		impl.deleteOrderItem(oiid);
		
		
//		OrderItemDao impl = new OrderItemImpl();
//		List<OrderItem> list = impl.getAllOrderItems();
//		
//		for(OrderItem order : list)
//		{
//			System.out.println(order);
//		}
        
        
		
		OrderItemDao impl = new OrderItemImpl();
		OrderItem order = impl.getOrderItemById(oiid);	
		order.setQuantity(1); 
		impl.updateQuantityAndPrice(order);
		
}
}
