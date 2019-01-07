package Problem3;

public class EmployeeFactory implements Factory{
	public Employee createEmployee(Type type)
	{
		Employee e = null;
		switch(type)
		{
			case FACULTY:
				e = new Faculty();
				break;
			case STAFF:
				e = new Staff();
				break;
			case PARTIME:
				e = new Partime();
				break;
		}
		return e;
	}
}
