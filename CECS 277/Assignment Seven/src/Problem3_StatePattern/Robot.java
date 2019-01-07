package Problem3_StatePattern;

public class Robot 
{
	private State currentState;
	
	public Robot()
	{
		currentState = null;
	}
	
	public void talk()
	{
		System.out.println("Talk");
	}
	
	public void cook()
	{
		System.out.println("Cook");
	}
	
	public void sing()
	{
		System.out.println("Sing");
	}
	
	public State getCurrentState()
	{
		return currentState;
	}
	
	public void setCurrentState(State state)
	{
		currentState = state;
	}
	
	public void execute()
	{
		currentState.execute(this);
	}	
}
