package Problem2;

public class ServerFactory implements ComputerAbstractFactory {
	private String RAM;
	private String CPU;
	
	public ServerFactory(String r, String c)
	{
		RAM = r;
		CPU = c;
	}
	
	public Computer createComputer()
	{
		return new Server(RAM, CPU);
	}
}