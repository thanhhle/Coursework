public class AssignmentEight 
{
	public static void main(String[] args)
	{
		A8Utils utils = new A8Utils();
		utils.printStars(0);
		utils.printStars(5);
		
		int[] numbers = { 41, 0, 74, -1, 8, -17, 79, 5, 22, -17 };
		System.out.println("Minumum is " + utils.min(numbers));
		
		String[] patterns = { "al ", "Sta", "eat", "eac" };
		for(int ii = 0; ii < patterns.length; ++ii)
		{
			System.out.println("Is pattern '" + patterns[ii] + "' in 'Cal State Long Beach'? " + utils.isIn(patterns[ii], "Cal State Long Beach"));
		}
		
		utils.permutations("1234");
		utils.permutations("ios");
		utils.countNumberOfPerms("LongBeach");
	}
}
