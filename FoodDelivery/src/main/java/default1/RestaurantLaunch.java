package default1;

import java.util.List;
import java.util.Scanner;

import com.tap.dao1.RestaurantDao;
import com.tap.dao1.userDao;
import com.tap.Daoimpl.RestaurantDaoImpl;
import com.tap.Daoimpl.userDaoImpl;
import com.tap.modles.Restaurant;
import com.tap.modles.user;

public class RestaurantLaunch {
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
//		System.out.println("Enter the restaurantID");
//		int id = sc.nextInt();
//		System.out.println("Enter the name");
//     	String name = sc.next();
//		System.out.println("Enter the address");
//		String address = sc.next();
//		System.out.println("Enter the phone");
//    	String phone = sc.next();
//		System.out.println("Enter the rating");
//		String rating = sc.next();
//		System.out.println("Enter the cusine");
//		String cusine = sc.next();
//		System.out.println("Enter the isactive");
//		Boolean isactive =sc.nextBoolean();
//		System.out.println("Enter the adminuserId");
//    	int adminuserId = sc.nextInt();
//    	System.out.println("Enter the imagepath");
//    	sc.nextLine();
//     	String imagepath = sc.nextLine();
////		
////		
//		Restaurant rest = new Restaurant(id, name, address, phone, rating, cusine, isactive, adminuserId, imagepath);
//		
//		RestaurantDao impl = new RestaurantDaoImpl();
//		impl.addRestaurant(rest);
//		
//		RestaurantDao impl = new RestaurantDaoImpl();
//		impl.deleteRestaurant(id);
		
		
		
		RestaurantDao impl = new RestaurantDaoImpl();
		List<Restaurant> list = impl.getAllRestaurants();
		
		for(Restaurant restaurant : list)
		{
			System.out.println(restaurant);
		}
		
		
//		RestaurantDao impl = new RestaurantDaoImpl();
//		impl.updateRestaurant(rest);
		
		
		
		
//		RestaurantDao impl = new RestaurantDaoImpl();
//		Restaurant restaurant = impl.getRestaurant(id);	
//		restaurant.setRating("4.0");
//		impl.updateRestaurant(restaurant);
}
}

