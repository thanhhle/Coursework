package Problem1_VisitorPattern;

public interface Product
{
	public abstract double accept(Visitor visitor);
	public abstract void display();
}
