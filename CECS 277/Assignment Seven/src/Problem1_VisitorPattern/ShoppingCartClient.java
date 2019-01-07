package Problem1_VisitorPattern;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartClient 
{
	public static void main(String[] args) 
	{
		List<Product> items = new ArrayList<Product>();
		items.add(new LaptopComputer("Microsoft Surface", 1500.00, 1));
		items.add(new LaptopComputer("HP", 900.00, 1));
		items.add(new MobilPhone("Apple", "iPhone X", 1000.00, 1));
		items.add(new MobilPhone("Apple", "iPhone 7", 300.00, 1));
		items.add(new MobilPhone("Samsung", "Galaxy S8", 800.00, 1));
		items.add(new MobilPhone("Samsung", "Galaxy S7", 600.00, 1));
		items.add(new VideoGame("Sony-Playstation", 200.00, 1));
		items.add(new VideoGame("Microsoft Xbox One", 150.00, 2));
		
		displayOrder(items);
		double total = calculateTotalPrice(items);
		System.out.println("Total price: " + total);
	}
	
	private static double calculateTotalPrice(List<Product> items)
	{
		Visitor visitor = new PriceVisitor();
		double total = 0;
		for(Product item: items)
		{
			total = total + item.accept(visitor);
		}
		return total;
	}

	private static void displayOrder(List<Product> items)
	{
		String productKind = items.get(0).getClass().getSimpleName();
		System.out.println(productKind + "\n" + "----------------------------------");
		
		for(int i = 0; i < items.size(); i++)
		{
			if(!productKind.equals(items.get(i).getClass().getSimpleName()))
			{
				productKind = items.get(i).getClass().getSimpleName();
				System.out.println(productKind + "\n" + "----------------------------------");
			}
			items.get(i).display();
		}
	}
}
