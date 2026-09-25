package fooddeliveryapp_mini_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MenuService {
	
	public ArrayList<MenuItem> getMenuItems(){
		 ArrayList<MenuItem> menuItems = new ArrayList<>();
		 String sql = "SELECT item_id, name, price, is_available FROM menu_items";
		  try (Connection conn = DatabaseConnection.getConnection();
		             PreparedStatement ps = conn.prepareStatement(sql);
		             ResultSet rs = ps.executeQuery()){
			  while(rs.next()) {
				  int itemId = rs.getInt("item_id");
	                String name = rs.getString("name");
	                double price = rs.getDouble("price");
	                boolean isAvailable = rs.getBoolean("is_available");
	                
	                MenuItem item = new MenuItem(itemId, name, price, isAvailable);
	                menuItems.add(item);
			  }
		  }catch(Exception e) {
			  System.out.println("Error loading menu.");
			  e.printStackTrace();
		  }
		  return menuItems;
	}
	
	  public void displayMenu(ArrayList<MenuItem> menuItems) {
		  if(menuItems.isEmpty()) {
			  System.out.println("No menu items available.");
			  return;
		  }
		  System.out.println("\n========== FOOD MENU ==========");
		  for(MenuItem item : menuItems) {
			  item.displayDetails();
		  }
		  System.out.println("===============================");
	  }
}

