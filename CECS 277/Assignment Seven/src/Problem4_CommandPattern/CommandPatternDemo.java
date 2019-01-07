package Problem4_CommandPattern;

import java.util.ArrayList;
import java.util.List;

public class CommandPatternDemo 
{
	public static void main(String[] args) 
	{
		Stock s1 = new Stock("computer", 100.00);
		Stock s2 = new Stock("phone", 49.99);
		Stock s3 = new Stock("fridge", 249.59);
		
		Trading d = new Trading();
		
		// Buy orders
		Order o1 = new BuyStock(s1, 2);
		Order o2 = new BuyStock(s2, 1);
	
		// Sell orders
		Order o3 = new SellStock(s3, 1);
		
		// Add these orders to a list
		List<Order> orders = new ArrayList<Order>();
		orders.add(o1);
		orders.add(o2);
		orders.add(o3);
		
		d.takeOrders(orders);
		d.executeOrders();
	}
}
