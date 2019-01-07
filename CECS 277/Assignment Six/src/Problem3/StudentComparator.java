package Problem3;

import java.util.Comparator;
import java.util.Map;

public class StudentComparator implements Comparator<Map.Entry<Student, String>>{
	public int compare(Map.Entry<Student, String> o1, Map.Entry<Student, String> o2)
	{
		Student s1 = o1.getKey();
		Student s2 = o2.getKey();
		if(s1.getLastName().equals(s2.getLastName()))
		{
			if(s1.getFirstName().equals(s2.getFirstName()))
			{
				return s1.getID() - s2.getID();
			}
			return s1.getFirstName().compareTo(s2.getFirstName());
		}
		return s1.getLastName().compareTo(s2.getLastName());
	}
}