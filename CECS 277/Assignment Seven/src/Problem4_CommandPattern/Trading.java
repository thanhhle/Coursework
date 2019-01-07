package Problem4_CommandPattern;

import java.util.ArrayList;
import java.util.List;

public class Trading 
{
	private List<Order> orders;
	
	public Trading()
	{
		orders = new ArrayList<Order>();
	}
	
	public void takeOrders(List<Order> list)
	{
		orders.addAll(list);
	}
	
	public void executeOrders()
	{
		for(Order o: orders)
		{
			o.execute();
		}
		orders.clear();
	}
}
