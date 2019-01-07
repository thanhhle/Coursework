//Thanh Le, 015809792, Assignment Eight
/**
 * 
 * @author Thanh Le
 * 
 * Recursion
 *
 */
public class A8Utils {
	// Print out 'n' *'s on the same line
	public void printStars(int n)
	{
		sop(n + " stars: ");
		doStars(n);
	}
	
	private void doStars(int n)
	{
		if(n == 0)	sopln("");
		else	
		{
			sop("*");
			doStars(n-1);
		}
	}
	
	
	// Return the minimum of the array
	public int min(int[] numbers)
	{
		if(numbers.length == 1)				return numbers[0];
		else
		{
			int[] temp = splitArray(1, numbers);
			if(numbers[0] <= min(temp))		return numbers[0];
			else							return min(temp);
		}
	}

	private int[] splitArray(int index, int[] array)
	{
		int[] arr = new int[array.length - index];
		for(int ii = index; ii < arr.length; ii++)
		{
			arr[ii - index] = array[ii];
		}
		return arr;
	}
	
	
	// Return Yes if pattern is found in target, No otherwise
	public String isIn(String pattern, String target)
	{
		boolean check = checkIsIn(pattern, target);
		return (check) ? "Yes" : "No";
	}
	
	private boolean checkIsIn(String pattern, String target)
	{
		if(pattern.length() > target.length())							return false;
		if(target.substring(0,  pattern.length()).equals(pattern))		return true;
		else															return checkIsIn(pattern, target.substring(1));
	}
	
	
	// Print all the permutations of word
	public void permutations(String word)
	{
		sopln("The " + factorial(word.length()) + " permutations of " + word + " sorted are:");
		doPerms("", word);
		sopln("");
	}
	
	private void doPerms(String perm, String word) 
	{
		if(word.length() == 0)		sop(perm + " ");
		else
		{
			for(int i=0; i<word.length(); i++)
			{
				doPerms(perm + word.charAt(i), word.substring(0, i) + word.substring(i+1));
			}
		}
	}


	// Return the number of permutations of word
	public void countNumberOfPerms(String word)
	{
		sopln("The number of permutations of " + word + " is " + factorial(word.length()));
	}
	
	private int factorial(int n)
	{
		if(n == 0)	return 1;
		else		return n*factorial(n-1);
	}
	
	
	private void sopln(String s)
	{
		System.out.println(s);
	}
	
	private void sop(String s)
	{
		System.out.print(s);
	}
}
