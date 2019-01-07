package Problem5_AdapterPattern;

public class SimpleName implements NameInterface
{
	private String name;
	
	public SimpleName(String name)
	{
		this.name = name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getName() 
	{
		return name;
	}
}
