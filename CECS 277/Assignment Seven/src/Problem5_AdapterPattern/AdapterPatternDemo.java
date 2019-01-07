package Problem5_AdapterPattern;

public class AdapterPatternDemo 
{
	public static void main(String[] args) 
	{
		FullNameInterface fullName = new SimpleNameToFullNameAdapter(new SimpleName("Thanh Le"));
		System.out.println(fullName.getFirstName());
		System.out.println(fullName.getLastName());
	}
}
