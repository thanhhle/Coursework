package Problem1_VisitorPattern;

public class LaptopComputer implements Product
{
	private String brand;
	private double price;
	private int quantity;
	
	public LaptopComputer(String brand, double price, int quantity)
	{
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getBrand() 
	{
		return brand;
	}
	
	public double getPrice() 
	{
		return price;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setBrand(String brand) 
	{
		this.brand = brand;
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	@Override
	public double accept(Visitor visitor) 
	{
		return visitor.visit(this);
	}
	
	public void display()
	{
		System.out.println('\t' + "Brand: " + brand + '\n' + 
						   '\t' + "Price: " + price + '\n' + 
						   '\t' + "Quantity: " + quantity + '\n');
	}
}