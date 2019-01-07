package Problem5_AdapterPattern;

public class SimpleNameToFullNameAdapter implements FullNameInterface
{
	private SimpleName name;
	private String firstName;
	private String lastName;
	
	public SimpleNameToFullNameAdapter(SimpleName name)
	{
		this.name = name;
		firstName = name.getName().split(" ")[0];
		lastName = name.getName().split(" ")[1];
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}	
}