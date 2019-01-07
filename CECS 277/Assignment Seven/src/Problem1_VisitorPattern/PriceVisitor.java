package Problem1_VisitorPattern;

public class PriceVisitor implements Visitor
{

	public double visit(Product product)
	{
		if(product instanceof LaptopComputer)
		{
			LaptopComputer lc = (LaptopComputer)product;
			if(lc.getBrand().equalsIgnoreCase("Microsoft Surface"))
				lc.setPrice(lc.getPrice()*80/100);
			return lc.getPrice()*lc.getQuantity();
		}	
		
		else if(product instanceof MobilPhone)
		{
			MobilPhone m = (MobilPhone)product;
			if(m.getBrand().equalsIgnoreCase("Apple") && m.getPrice() >= 400.00)
				m.setPrice(m.getPrice()-30);
	
			if(m.getBrand().equalsIgnoreCase("Samsung") && m.getModel().equalsIgnoreCase("Galaxy S8"))
				m.setPrice(m.getPrice()*80/100);
	
			return m.getPrice()*m.getQuantity();
		}
		
		else if(product instanceof VideoGame)
		{
			VideoGame v = (VideoGame)product;
			if(v.getBrand().equalsIgnoreCase("Sony-Playstation"))
				v.setPrice(((VideoGame)product).getPrice()*80/100);
		
			if(v.getBrand().equalsIgnoreCase("Microsoft Xbox One") && v.getQuantity() == 2)
				v.setPrice(v.getPrice()*70/100);
			
			return v.getPrice()*v.getQuantity();
		}
			
		else	return 0;
	}
}