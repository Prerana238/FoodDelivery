package default1;
import java.util.List;
import java.util.Scanner;

import com.tap.Daoimpl.MenuImpl;
import com.tap.Daoimpl.userDaoImpl;
import com.tap.modles.Menu;
import com.tap.modles.user;
import com.tap.dao1.MenuDao;
import com.tap.dao1.userDao;


public class MenuLaunch {

public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
//		System.out.println("Enter the menuId");
//		int mid = sc.nextInt();
//		System.out.println("Enter the restaurantId");
//		int rid = sc.nextInt();
//		System.out.println("Enter the itemName");
//		String itemName = sc.next();
//		System.out.println("Enter the description");
//		String description = sc.next();
//		System.out.println("Enter the price");
//		double price = sc.nextDouble();
//		System.out.println("Enter the ratings");
//		int ratings = sc.nextInt();
//		System.out.println("Enter the isAvailable");
//		String isAvailable = sc.next();
//		System.out.println("Enter the imagepath");
//    	sc.nextLine();
//     	String imagepath = sc.nextLine();
//		
//		
//     	Menu menuItem = new Menu(mid, rid, itemName, description, price, ratings, isAvailable, imagepath);
     	
//        MenuDao impl = new MenuImpl();
//        impl.addMenuItem(menuItem);
		
        
//       MenuDao impl = new MenuImpl();
//       impl.deleteMenuItem(mid);
        
        
        MenuDao impl = new MenuImpl();
        int restaurantId = 1;
		List<Menu> list = impl.getAllMenuItems(restaurantId);
		
		for(Menu menu : list)
		{
			System.out.println(menu);
		}
        
        
		
//		MenuDao impl = new MenuImpl();
//		Menu menu = impl.getMenuItemById(mid);	
//		menu.setPrice(100); 
//		impl.updateMenuItem(menu);
        
}
}

