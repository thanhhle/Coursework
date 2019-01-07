package Problem2_DecoratorPattern;

public class PizzaDecorator implements PizzaInt
{
	protected PizzaInt decoratedPizza;
	
	public PizzaDecorator(PizzaInt decoratedPizza)
	{
		this.decoratedPizza = decoratedPizza;
	}
	
	public void makePizza()
	{
		decoratedPizza.makePizza();
	}
}