//Thanh Le, 015809792, Assignment Seven
/**
 * 
 * @author Thanh Le
 * 
 * A simple Queue class
 *
 */
public class Queue {
	
	/**
	 * Make a new empty Queue
	 */
	public Queue()
	{
		mQueue = new List();
	}
	
	/**
	 * Add item to the rear of the Queue
	 * @param item the item to add
	 */
	public void add(String item)
	{
		mQueue.addToRear(item);
	}
	
	/**
	 * Remove and return the front of the Queue
	 * @return the front of the Queue
	 */
	public String remove()
	{
		String s = mQueue.getFront();
		mQueue.removeFront();
		return s;
	}
	
	/**
	 * Test if the Queue is empty
	 * @return true if Queue is empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return mQueue.askCount() == 0;
	}
	
	/**
	 * Print the content of the Queue using the same format as the List prints
	 * @param title the description of the Queue
	 */
	public void dump(String title)
	{
		mQueue.print(title);
	}
	
	private List mQueue;
}
