package Problem1_VisitorPattern;

public class MobilPhone implements Product
{
	private String brand;
	private String model;
	private double price;
	private int quantity;
	
	public MobilPhone(String brand, String model, double price, int quantity)
	{
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.quantity = quantity;
	}

	public String getBrand() 
	{
		return brand;
	}
	
	public String getModel() {
		return model;
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
	
	public void setModel(String model) 
	{
		this.model = model;
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
						   '\t' + "Model: " + model + '\n' + 
						   '\t' + "Price: " + price + '\n' + 
						   '\t' + "Quantity: " + quantity + '\n');
	}
	
}
