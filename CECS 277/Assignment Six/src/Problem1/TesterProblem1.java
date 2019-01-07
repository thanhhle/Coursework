package Problem1;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class TesterProblem1 {

	public static void main(String[] args) throws IOException
	{
		PrintStream console = new PrintStream(new File("outputStudents.txt"));
		Scanner inputFile = new Scanner(new File("input.txt"));
		String input = "";
		while(inputFile.hasNext())
		{
			input += inputFile.next();
		}
		
		Map<Character, Integer> myMap = toMap(input);
		
		console.println("Map contains: ");
		
		console.println("\nSort by key");
		Map<Character, Integer> sortedByKeyMap = sortByKey(myMap);
		display(sortedByKeyMap, console);
		
		console.println("\nSort by value");
		Map<Character, Integer> sortedByValueMap = sortByValue(myMap);
		display(sortedByValueMap, console);
	}
	
	public static Map<Character, Integer> toMap(String str)
	{
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		str = str.toLowerCase().replaceAll("[^a-z]", "");
		for(int i = 0; i < str.length(); i++)
		{
			char letter = str.charAt(i);
			if(!map.containsKey(letter))			map.put(letter, 1);
			else									map.put(letter, map.get(letter) + 1);
		}
		return map;
	}
	
	public static Map<Character, Integer> sortByKey(Map<Character, Integer> map)
	{
		Map<Character, Integer> sortedMap = new TreeMap<Character, Integer>();
		sortedMap.putAll(map);
		return sortedMap;
	}
	
	public static Map<Character, Integer> sortByValue(Map<Character, Integer> map)
	{
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(map.entrySet());
		Collections.sort(list, new ValueComparator());
		Map<Character, Integer> sortedMap = new LinkedHashMap<Character, Integer>();
		for(Map.Entry<Character, Integer> entry: list)
		{
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
	
	public static void display(Map<Character, Integer> map, PrintStream console)
	{
		for(Map.Entry<Character, Integer> entry: map.entrySet())
		{
			console.println(entry.getKey() + "\t\t" + entry.getValue());
		}
	}
}