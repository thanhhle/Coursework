//Thanh Le, 015809792, Assignment Five
/**
 * 
 * @author Thanh Le
 * 
 * A simple List class
 *
 */
public class AssignmentFive
{
	public static void main(String[] args)
	{
		List myList = new List();
		List emptyList = new List(myList);
		
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
		emptyList.print("Empty List");
		
		List copyOfList = new List(myList);
			
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
		
		copyOfList.print("Untouched copy of the list");
		
		myList.removeFront();
		myList.removeRear();
		myList.removeItem("moremorejunk");
		myList.print("List with junk removed");
		sop("Count is " + myList.askCount());
		sop("");
		
		copyOfList.print("Untouched copy of the list");
		
		while(myList.askCount() > 0) myList.removeFront();
		
		myList.print("List after removing all items");
		copyOfList.print("Copy of List after removing all items");
	}
	
	private static void sop(String s)
	{
		System.out.println(s);
	}
}
