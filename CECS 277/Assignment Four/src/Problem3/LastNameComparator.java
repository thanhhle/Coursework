package Problem3;

import java.util.Comparator;

/**
 * Class LastNameComparator
 * <p>
 * @author Thanh Le
 * @version 1.0
 * @Fall 2017
 */
public class LastNameComparator implements Comparator{
	public int compare(Object o1, Object o2)
	{
		Employee e1 = (Employee)o1;
		Employee e2 = (Employee)o2;
		
		return e1.getLastName().compareTo(e2.getLastName());
	}
}