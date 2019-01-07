package Problem1;

abstract class Cake {
	
	private String name;
	private boolean lessButter;
	private double price;
	
	public Cake()
	{
		
	}
	
	public Cake(String n, boolean c, double p)
	{
		name = n;
		lessButter = c;
		price = p;
	}
	
	abstract void recipe();
	abstract void comments();
	
	public void aboutCake()
	{
		System.out.print("Name: " + name + '\n' + "Price: " + price + '\n' + "Comments: ");
		comments();
	}
}