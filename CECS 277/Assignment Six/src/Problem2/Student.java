package Problem2;
import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable{

	public Student()
	{
		firstName = lastName = "";
		id = 0;
	}
	
	public Student(String firstName, String lastName, int id)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public int getID() 
	{
		return id;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public void setID(int id)
	{
		this.id = id;
	}
	
	public void inputStudent(Scanner input)
	{
		setFirstName(input.next());
		setLastName(input.next());
		setID(input.nextInt());
	}

	public int hashCode()
	{
		final int HASH_MULTIPLIER = 29;
		int h = HASH_MULTIPLIER * firstName.hashCode() + lastName.hashCode();
		h = HASH_MULTIPLIER * h + ((Integer)id).hashCode();
		return h;
	}

	public boolean equals(Object o)
	{
		if(!(o instanceof Student))			return false;
		else								return (lastName.equals(((Student)o).getLastName()));
	}
	
	public String toString()
	{
		return  "First Name: " + firstName + '\n' +
				"Last Name: " + lastName + '\n' +
				"ID: " + id;
	}
	
	private String firstName;
	private	String lastName;
	private int id;
}
