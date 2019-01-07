package Problem1;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<Map.Entry<Character, Integer>>
{	
	public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2)
	{
		return entry2.getValue() - entry1.getValue();
	}
}