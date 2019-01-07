package Problem2;

public class ComputerTester {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer(new PCFactory("2GB", "Intel"));
		System.out.println(pc.getClass().getSimpleName());
		System.out.println("PC Configration: " + pc);

		Computer ser = ComputerFactory.getComputer(new ServerFactory("10GB", "Intel"));
		System.out.println("Server Configration: " + ser);
	}
}