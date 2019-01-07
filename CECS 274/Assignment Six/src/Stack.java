//Thanh Le, 015809792, Assignment Six
/**
 * 
 * @author Thanh Le
 * 
 * A simple Stack class
 *
 */
public class Stack {
	/**
	 * Creates an empty Stack
	 */
	public Stack()
	{
		mStack = new List();
	}
	
	/**
	 * Makes item the Top of the stack
	 * @param item the item to be pushed onto the Stack.
	 */
	public void push(String item)
	{
		mStack.addToFront(item);
	}
	
	/**
	 * Removes the Top of the Stack
	 */
	public void pop()
	{
		mStack.removeFront();
	}
	
	/**
	 * Returns the element on the top of the stack but does not remove it
	 * @return the Top of the Stack
	 */
	public String getTop()
	{
		return mStack.getFront();
	}
	
	/**
	 * Test if this stack is empty
	 * @return Return true if Stack is empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return mStack.askCount() == 0;
	}
	
	/**
	 * Print the content of the Stack using the same format as the List prints
	 * @param title the description of the Stack
	 */
	public void dump(String title)
	{
		mStack.print(title);
	}
	
	//class variable
	private List mStack;
}
