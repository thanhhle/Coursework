package Problem4_CommandPattern;

public class Stock 
{
	private String name;
	private double price;
	
	public Stock(String name, double price)
	{
		this.name = name;
		this.price = price;
	}
	
	public void buy(int quantity)
	{
		System.out.println("BOUGHT: " + quantity + "x " + this);
	}
	
	public void sell(int quantity)
	{
		System.out.println("SOLD: " + quantity + "x " + this);
	}
	
	public String toString()
	{
		return "Product [name=" + name + ", price=" + price + "]";
	}
}
