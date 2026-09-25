package fooddeliveryapp_mini_Project;

import java.util.ArrayList;
import java.util.Scanner;

public class FoodDeliveryApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 MenuService menuService = new MenuService();
	        OrderService orderService = new OrderService();
	        
	        String customerId = "C101";
	        ArrayList<MenuItem> menuItems = menuService.getMenuItems();
	        int choice = 0;
	        
	        while(choice!=4) {
	        	
	        	 System.out.println("\n===== FOOD DELIVERY APP =====");
	             System.out.println("1. Browse Menu");
	             System.out.println("2. Place Order");
	             System.out.println("3. View My Order History");
	             System.out.println("4. Exit");
	             System.out.print("Enter your choice: ");
	             
	             try {
	            	 choice = Integer.parseInt(sc.nextLine()); // stored the choice
	            	 
	            	 switch(choice) {
	            	 	
	            	 case 1:
	            		 menuService.displayMenu(menuItems);
                     break;
	            	 case 2:
	            		 System.out.print("Enter Item ID: ");
	                        int itemId = Integer.parseInt(sc.nextLine());
	                        MenuItem selectedItem = null;
	                        for (MenuItem item : menuItems) {

	                            if (item.getItemId() == itemId) {
	                                selectedItem = item;
	                                break;
	                            }
	                        }
	                        if (selectedItem == null) {
	                            System.out.println("Item not found.");
	                            break;
	                        }
	                        if (!selectedItem.IsAvailable()) {
	                            System.out.println("Sorry, " + selectedItem.getName() + " is currently unavailable.");
	                            break;
	                        }
	                        System.out.print("Enter Restaurant ID: ");
	                        int restaurantId = Integer.parseInt(sc.nextLine());
	                        orderService.placeOrder(customerId, restaurantId, selectedItem.getPrice());
	                        
	                        break;
	            	 case 3:
//	            		 System.out.println( "Order history will be added next.");
	            		 orderService.viewOrderHistory(customerId);
	            		 break;
	            	 case 4:
	            		 System.out.println("Thank you for using Food Delivery App!");
	                        break;
	                        default:
	                        	System.out.println("Invalid choice.");
	            	 }
	            	 
	             }catch(NumberFormatException e) {
	            	 System.out.println("Please enter a valid number.");
	             }
	        	
	        }
	        sc.close();

	}

}
