package Problem1;

import Comparator.ValueComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Tester 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String input = scanner.nextLine();
		
		Map<Character, Integer> myMap = toMap(input);
		
		System.out.println("\nMap contains: ");
		
		System.out.println("\nSort by key");
		Map<Character, Integer> sortedByKeyMap = sortByKey(myMap);
		display(sortedByKeyMap);
		
		System.out.println("\nSort by value");
		Map<Character, Integer> sortedByValueMap = sortByValue(myMap);
		display(sortedByValueMap);
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
	
	public static void display(Map<Character, Integer> map)
	{
		for(Map.Entry<Character, Integer> entry: map.entrySet())
		{
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
}