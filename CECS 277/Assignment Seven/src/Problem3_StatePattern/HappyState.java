package Problem3_StatePattern;

public class HappyState implements State
{
	public void execute(Robot robot)
	{
		robot.talk();
		robot.cook();
		System.out.println(); 
	}
}
