package Problem2;

public class PC extends Computer{
	private String RAM;
	private String CPU;
	
	public PC(String r, String c)
	{
		RAM = r;
		CPU = c;
	}
	
	public String getRAM()
	{
		return RAM;
	}
	
	public String getCPU()
	{
		return CPU;
	}
}