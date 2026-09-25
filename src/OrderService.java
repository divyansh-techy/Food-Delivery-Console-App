package fooddeliveryapp_mini_Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrderService {
	public void placeOrder(String customerId, int restaurantId, double amount) {
		String walletSql = "UPDATE customers SET wallet_balance = wallet_balance - ? WHERE customer_id = ? AND wallet_balance >= ?";
		 String orderSql = "INSERT INTO orders (customer_id, restaurant_id, amount) VALUES (?, ?, ?)";
		 
		 try (Connection conn = DatabaseConnection.getConnection()){
			
			 conn.setAutoCommit(false);
			 try (PreparedStatement walletPs = conn.prepareStatement(walletSql);
	                 PreparedStatement orderPs = conn.prepareStatement(
	                         orderSql, Statement.RETURN_GENERATED_KEYS)){
				 
				 // 1. Deduct money from wallet
	                walletPs.setDouble(1, amount);
	                walletPs.setString(2, customerId);
	                walletPs.setDouble(3, amount);

	                int walletRows = walletPs.executeUpdate();
	                
	                if (walletRows == 0) {
	                    throw new RuntimeException(
	                            "Insufficient wallet balance or customer not found."
	                    );
	                }
	             // 2. Insert order
	                orderPs.setString(1, customerId);
	                orderPs.setInt(2, restaurantId);
	                orderPs.setDouble(3, amount);

	                int orderRows = orderPs.executeUpdate();

	                if (orderRows == 0) {
	                    throw new RuntimeException("Order could not be created.");
	                }
	                
	             // 3. Everything successful
	                conn.commit();
	                System.out.println("Order placed successfully!");
	                try (ResultSet rs = orderPs.getGeneratedKeys()) {
	                    if (rs.next()) {
	                        System.out.println("Order ID: " + rs.getInt(1));
	                    }
	                }
			 }
			 catch (Exception e) {

	                conn.rollback();

	                System.out.println("Order failed. Transaction rolled back.");
	                System.out.println("Reason: " + e.getMessage());
		 }
	}
		 catch (Exception e) {
        System.out.println("Database error: " + e.getMessage());
    }
}
	
	public void viewOrderHistory(String customerId) {
		String sql = "SELECT o.order_id, r.restaurant_name, o.amount, o.order_date FROM orders o JOIN restaurants r ON o.restaurant_id = r.restaurant_id WHERE o.customer_id = ? ORDER BY o.order_date DESC";
		try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, customerId);
			try (ResultSet rs = ps.executeQuery()){
				boolean found = false;
				   System.out.println("\n========== MY ORDER HISTORY ==========");
		            System.out.printf("%-10s %-20s %-12s %-25s%n", "Order ID", "Restaurant", "Amount", "Order Date");
		            System.out.println("------------------------------------------------------------");
		            while(rs.next()) {
		            	 found = true;

		                 int orderId = rs.getInt("order_id");
		                 String restaurantName = rs.getString("restaurant_name");
		                 double amount = rs.getDouble("amount");
		                 String orderDate = rs.getString("order_date");
		                 
		                 System.out.printf("%-10d %-20s Rs.%-9.2f %-25s%n", orderId, restaurantName, amount, orderDate);
		                 
		            }
		            if (!found) {
		                System.out.println("No orders found.");
		            }
		            System.out.println( "=====================================");
			}
		}catch (Exception e) {
	        System.out.println("Error loading order history.");
	        e.printStackTrace();
	}
	}
}
