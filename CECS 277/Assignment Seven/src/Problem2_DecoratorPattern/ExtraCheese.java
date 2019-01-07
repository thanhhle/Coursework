package Problem2_DecoratorPattern;

public class ExtraCheese extends PizzaDecorator
{	
	public ExtraCheese(PizzaInt decoratedPizza)
	{
		super(decoratedPizza);
	}

	public void makePizza()
	{
		decoratedPizza.makePizza();
		System.out.println("Add extra cheese");
	}
}
