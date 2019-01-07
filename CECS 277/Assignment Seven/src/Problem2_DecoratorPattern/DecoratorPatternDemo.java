package Problem2_DecoratorPattern;

public class DecoratorPatternDemo 
{
	public static void main(String[] args) 
	{
		PizzaInt p1 = new Pepperoni(new Pizza());
		PizzaInt p2 = new Sausage(new Pepperoni(new Pizza()));
		PizzaInt p3 = new ExtraCheese(new Pepperoni(new Sausage(new Pizza())));
		p1.makePizza();
		p2.makePizza();
		p3.makePizza();
	}
}
