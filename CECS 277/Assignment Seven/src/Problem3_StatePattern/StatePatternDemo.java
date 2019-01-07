package Problem3_StatePattern;

public class StatePatternDemo 
{
	public static void main(String[] args) 
	{
		Robot r = new Robot();
		r.setCurrentState(new HappyState());
		r.execute();
		
		r.setCurrentState(new BoringState());
		r.execute();
		r.execute();
	}
}
