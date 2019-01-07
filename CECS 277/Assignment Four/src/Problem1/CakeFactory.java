package Problem1;

public class CakeFactory implements Factory{
	
	public Cake createCake(String name)
	{
		Cake c;
		if(name.equalsIgnoreCase("CakeA"))			return c = new CakeA();
		else if(name.equalsIgnoreCase("CakeB"))		return c = new CakeB();
		else if(name.equalsIgnoreCase("CakeC"))		return c = new CakeC();
		
		return null;
	}
}
