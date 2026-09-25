package fooddeliveryapp_mini_Project;


public class MenuItem {
	private int itemId;
    private String name;
    private double price;
    private boolean isAvailable;
    
    public MenuItem(int itemId, String name, double price, boolean isAvailable) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
    }

	public int getItemId() {
		return itemId;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public boolean IsAvailable() {
		return isAvailable;
	}
	
	 public void displayDetails() {
		 if(isAvailable) {
			 System.out.println( itemId + " | " + name + " | Rs." + price);
		 }else {
			 System.out.println(itemId + " | " + name + " [UNAVAILABLE] | Rs." + price);
		 }
	 }   
}
