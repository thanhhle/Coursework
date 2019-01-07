package Problem2;

abstract class Computer {
	public abstract String getRAM();
	public abstract String getCPU();
	
	public String toString()
	{
		return "CPU: " + getCPU() + ", RAM: " + getRAM();
	}
}
