//Thanh Le, 015809792, Assignment Three
/**
 * 
 * @author Thanh Le
 * 
 * Assignment Three
 *
 */
public class AssignmentThree 
{
	public static void main(String[] args)
	{
		List myList = new List(15);
		
		// Cause List Empty Message
		myList.removeFront();
		myList.removeRear();
		myList.removeItem("a");
		
		// Cause Not found message
		myList.addToFront("x");
		myList.removeItem("y");
		myList.removeItem("x");
		myList.addAfterItem("x", "z");
		myList.addBeforeItem("x", "z");
			
		// Normal behavior
		myList.addToFront("not.");
		myList.addToFront("or");
		myList.addToRear("is");
		myList.addToRear("try.");
		myList.addAfterItem("is", "no");
		myList.addBeforeItem("is", "There");
		myList.addToFront("Do");
		myList.addAfterItem("or", "do");
		
		myList.print("Original list");
		myList.printSorted("Sorted Original List");
			
		sop("\nFront is " + myList.getFront());
		sop("Rear is " + myList.getRear());
		sop("Count is " + myList.askCount());
		sop("Is There present? " + myList.isPresent("There"));
		sop("Is Dog present? " + myList.isPresent("Dog"));
	
		myList.addToFront("junk");
		myList.addToRear("morejunk");
		myList.addAfterItem("or", "moremorejunk");
		
		myList.print("List with junk");
		sop("Count is " + myList.askCount());
		
		myList.removeFront();
		myList.removeRear();
		myList.removeItem("moremorejunk");
		myList.print("List with junk removed");
		sop("Count is " + myList.askCount());
		sop("");
		
		// Cause List Full message
		for(int ii = 0; ii < 10; ++ii)
		{
			myList.addToFront(DUMMY);
		}
		
		myList.addToRear(DUMMY);
		myList.addBeforeItem("no", DUMMY);
		myList.addAfterItem("There", DUMMY);
		
		myList.print("After filling List");
		sop("Count is " + myList.askCount());
		
		while(myList.isPresent(DUMMY)) myList.removeItem(DUMMY);
		
		myList.print("After removing " + DUMMY );
		sop("Count is " + myList.askCount());
	}
	
	private static void sop(String s)
	{
		System.out.println(s);
	}
		
	private static final String DUMMY = "dummy";
}
