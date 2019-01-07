package Problem3_StatePattern;

public class BoringState implements State
{
	public void execute(Robot robot)
	{	
		robot.sing();
		System.out.println("Go in happy state");
		robot.setCurrentState(new HappyState());
		System.out.println();
	}
}
