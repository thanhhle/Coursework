package Problem2;

public class PCFactory implements ComputerAbstractFactory {
	private String RAM;
	private String CPU;
	
	public PCFactory(String r, String c)
	{
		RAM = r;
		CPU = c;
	}
	
	public Computer createComputer()
	{
		return new PC(RAM, CPU);
	}
}