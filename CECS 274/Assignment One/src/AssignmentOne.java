// Thanh Le, 015809792, Assignment One

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;


public class AssignmentOne 
{
	public static void main(String[] args) 
	{
		
		ArrayList<String> input = getInput(args[0]);
		
		printInput(input);
		printInputAndLengths(input);
		printReverseInput(input);
		printSortedInput(input);
		
		int[] theInts = generateRandomInts();
		
		printInts(theInts);
		printAverage(theInts);
		printStdDev(theInts);
		printSquareRoots(theInts);
		
	}
	
	/**
	 * Prints out the content of the array list with a title above.
	 * @param input A list of strings
	 */
	private static void printInput(ArrayList<String> input)
	{
		printInput("The Input File", input, false);
	}
	
	
	/**
	 * Prints out the content of the string array list with a title and the length of each element.
	 * @param input A list of strings
	 */
	private static void printInputAndLengths(ArrayList<String> input)
	{
		printInput("The Input File and Lengths", input, true);
	}
	
	
	/**
	 * Prints out the content of the string array list with a title above. When the withLengths is set to True, the length of each element in the array list will be displayed. Conversely, if the withLengths is set to be False, the length of each element in the array list will not be displayed.
	 * @param title A title of the string array list
	 * @param input A list of strings
	 * @param withLengths True: to include the lengths of each element in the string array list; False: to not include the lengths of each element in the string array list
	 */
	private static void printInput(String title, ArrayList<String> input, boolean withLengths)
	{
		System.out.println("\n" + title + "\n");
		for(String s : input)
		{
			System.out.print(s + " ");
			if(withLengths) System.out.print(s.length());
			System.out.println();
		}	
	}
	
	
	/**
	 * Prints out the random integers in the integer array
	 * @param theInts An array of the random integers 
	 */
	private static void printInts(int[] theInts)
	{
		System.out.println("\nSome Random Integers\n");
		for(int ii = 0; ii < theInts.length; ++ii)
		{
			System.out.println(theInts[ii]);
		}
		
	}
	
	
	/**
	 * Prints out reversed elements in the string array list
	 * @param input A list of strings
	 */
	private static void printReverseInput(ArrayList<String> input)
	{
		System.out.println("\nThe Input File Reversed\n");
		
		for(String s : input)
		{
			String reverse = "";
			int pos = s.length() - 1;
			while(pos >= 0) reverse += s.charAt(pos--);
			System.out.println(reverse);
		}
	}
	
	
	/**
	 * Sorts the array list and prints out the sorted content of the string array list without the length of each element.
	 * @param input A list of strings
	 */
	private static void printSortedInput(ArrayList<String> input)
	{
		ArrayList<String> sorted = new ArrayList<String>(input);
		Collections.sort(sorted);
		printInput("Sorted String Input", sorted, false);
		
	}
	
	
	/**
	 * Reads words from the Scanner until there are no more words in the file which has the input fileName and returns these words in a list of strings. If the file with the input fileName cannot be found, the method returns nothing and prints out a message to notice the error.
	 * @param fileName A name of the file which the Scanner reads
	 * @return The list of strings which contains the content in the file which has the input fileName; Nothing if an error is found.
	 */
	
	private static ArrayList<String> getInput(String fileName)
	{
	     try
	     {
	    	ArrayList<String> input = new ArrayList<String>();
	    	Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
	        
	        while(sc.hasNext()) input.add(sc.next());
	        sc.close();
	        
	        return input;
	        
	     }
	     catch(Exception exc)
	     {
	    	 System.out.println("Exception: " + exc.getMessage() + " opening input file " + fileName);
	    	 System.exit(0);
	     }
	     
		return null;
	}

	
	/**
	 * Generates 15 random integers between 0 and the maximum value (2 to the power of 20) inclusive and returns the integers 
	 * @return The array of the 15 random integers which has values between 0 and maximum value (2 to the power of 20) inclusive.
	 */
	private static int[] generateRandomInts()
	{
		final int SIZE = 15;
		int[] output = new int[SIZE];
		Random gen = new Random();
		
		final int MAX = (int)(Math.pow(2, 20));
		
		for(int ii = 0; ii < SIZE; ++ii) output[ii] = gen.nextInt(MAX);
		
		return output;
	}
	
	
	/**
	 * Computes and returns the sum of the integers in the array.
	 * @param input An array of integers
	 * @return The sum of the integers
	 */
	private static int getSum(int[] input)
	{
		int sum = 0;
		for(int ii = 0; ii < input.length; ++ii) sum += input[ii];
		
		return sum;
	}
	
	
	/**
	 * Computes and returns the average of the integers in the array. If the array has no elements, this method will return 0.0.
	 * @param input An array of integers
	 * @return The average of the integers
	 */
	private static double getAverage(int[] input)
	{
		double size = input.length;
		
		if(size == 0) return 0.0;
		else
		{
			return getSum(input) / size;
		}
		
	}
	
	
	/**
	 * Computes and returns the standard deviation of the integers in the array. If the array has no elements, this method will return 0.0.
	 * @param input An array of integers
	 * @return The standard deviation of the integers in the array; 0 if the array has no elements
	 */
	private static double getStdDev(int[] input)
	{
		double stdDev = 0.0;
		int n = input.length;
		
		if(n == 0) return 0.0;
		else
		{
			double ave = getAverage(input);
			
			for(int ii = 0; ii < n; ++ii)
			{
				stdDev += (input[ii] - ave) * (input[ii] - ave);
			}
			
			return Math.sqrt(stdDev / n);
		}
	}
	
	
	/**
	 * Prints out the average of the integers in the array.
	 * @param input An array of integers
	 */
	private static void printAverage(int[] input)
	{
		System.out.println("\nThe average of the " + input.length + " integers is " + getAverage(input));
	}
	
	
	/**
	 * Prints out the standard deviation of the integers in the array.
	 * @param input An array of integers
	 */
	private static void printStdDev(int[] input)
	{
		System.out.println("\nThe Standard Deviation of the " + input.length + " integers is " + getStdDev(input));
	}
	
	
	/**
	 * Prints out the integers, the square roots of the integers calculated by method of Newton and the method in Math module, and the difference between the results found by the two methods.
	 * @param input An array of integers
	 */
	private static void printSquareRoots(int[] input)
	{
		System.out.println("\nn\tNewtonRaphson    \tMath.sqrt        \tDifference\n");
		
		for(int ii = 0; ii < input.length; ++ii)
		{
			double v1 = NewtonRaphsonSqrt(input[ii]);
			double v2 = Math.sqrt(input[ii]);
			
			System.out.println(input[ii] + "\t" + v1 + "\t" + v2 + "\t" + (v1 - v2));
		}
	}
	
	
	/**
	 * Computes and returns the square root of the input decimal number by Newton's method
	 * @param n A decimal number
	 * @return The square root of the input decimal number
	 */
	private static double NewtonRaphsonSqrt(double n)
	{
		final int MAX_TRIES = 10000000;
		final double EPS = 0.0000001;
		
		double answer = n / 2.0;
		int tries = 0;
		
		while(Math.abs(answer * answer - n) > EPS && tries < MAX_TRIES)
		{
			answer = answer - ((answer * answer - n)/(2 * answer));
			++tries;
		}
		
		return answer;
	}
	
	
}
