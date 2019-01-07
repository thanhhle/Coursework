import java.util.ArrayList;
import java.util.Collections;
//Thanh Le, 015809792, Assignment Four
/**
 * 
 * @author Thanh Le
 * 
 * A simple List class
 *
 */
public class List {
	/**
	 * Create a List
	 */
	public List()
	{
		mCount = 0;
		mFront = new Node(null);
		mRear = new Node(null);
		mFront.mNext = mRear;
		mRear.mPrev = mFront;
	}

	/**
	 * Create a List with the items in the input list.
	 * @param list the List to duplicate
	 */
	public List(List list)
	{
		this();
		for(Node n = list.mFront.mNext; n != list.mRear; n=n.mNext)
		{
			addToRear(n.mData);
		}
	}
	
	/**
	 * If the List is not full, item becomes the new front element
	 * If the List is full, prints "List Full"
	 * @param item the item to add
	 */
	public void addToFront(String item)
	{
		Node newNode = new Node(item);
		newNode.mPrev = mFront;
		newNode.mNext = mFront.mNext;
		newNode.mPrev.mNext = newNode;
		newNode.mNext.mPrev = newNode;
		mCount++;
	}
	
	/**
	 * If the List is not full, item becomes the new rear element
	 * If the List is full, prints "List Full"
	 * @param item the item to add
	 */
	public void addToRear(String item)
	{
		Node newNode = new Node(item);
		newNode.mNext = mRear;
		newNode.mPrev = mRear.mPrev;
		newNode.mPrev.mNext = newNode;
		newNode.mNext.mPrev = newNode;
		mCount++;	
	}
	
	/**
	 * If the List is not full and beforeItem is in the List item becomes the element before beforeItem
	 * If the List is full, prints "List Full"
	 * If List is not full but beforeItem is not in List, prints "Item Not Found"
	 * @param beforeItem the item in the list to add item before
	 * @param item the item to add
	 */
	public void addBeforeItem(String beforeItem, String item)
	{
		Node beforeNode = find(beforeItem);
		if(beforeNode == null)
		{
			System.out.println("Item Not Found");
			return;
		}
		
		Node newNode = new Node(item);
		newNode.mNext = beforeNode;
		newNode.mPrev = beforeNode.mPrev;
		newNode.mPrev.mNext = newNode;
		newNode.mNext.mPrev = newNode;
		mCount++;
	}
	
	/**
	 * If the List is not full and afterItem is in the List item becomes the element after afterItem
	 * If the List is full, prints "List Full"
	 * If List is not full but afterItem is not in List, prints "Item Not Found"
	 * @param afterItem the item in the list to add item before
	 * @param item the item to add
	 */
	public void addAfterItem(String afterItem, String item)
	{
		Node afterNode = find(afterItem);
		if(afterNode == null)
		{
			System.out.println("Item Not Found");
			return;
		}
		
		Node newNode = new Node(item);
		newNode.mPrev = afterNode;
		newNode.mNext = afterNode.mNext;
		newNode.mPrev.mNext = newNode;
		newNode.mNext.mPrev = newNode;
		mCount++;
	}
	
	/**
	 * Returns the item at the front of the List
	 * List is not altered
	 * @return the item at the front of the List
	 */
	public String getFront()
	{
		return mFront.mNext.mData;
	}

	/**
	 * Returns the item at the rear of the List 
	 * List is not altered
	 * @return the item at the rear of the List
	 */
	public String getRear()
	{	
		return mRear.mPrev.mData;
	}
	
	/**
	 * Return true if item is in List, false otherwise
	 * @param item item to check presence in List
	 * @return true if item is in List, false otherwise
	 */
	public boolean isPresent(String item)
	{
		Node newNode = find(item);
		if(newNode == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Returns the number of items in the List
	 * @return the number of items in the List
	 */
	public int askCount()
	{	
		return mCount;
	}
	
	/**
	 * If the List is empty, prints "List Empty"
	 * If the List is not empty, removes the item at the front of the List
	 */
	public void removeFront()
	{
		if(mCount == 0)
		{
			System.out.println("List Empty");
		}
		else
		{
			mFront.mNext = mFront.mNext.mNext;
			mFront.mNext.mPrev = mFront;
			mCount--;
		}
	}
	
	/**
	 * If the List is empty, prints "List Empty"
	 * If the List is not empty, removes the item at the rear of the List
	 */
	public void removeRear()
	{
		if(mCount == 0)
		{
			System.out.println("List Empty");
		}
		else
		{
			mRear.mPrev = mRear.mPrev.mPrev;
			mRear.mPrev.mNext = mRear;
			mCount--;
		}
	}
	
	/**
	 * If the List is empty, prints "List Empty"
	 * If item is not present in List, prints "Item not found"
	 * Otherwise, item is removed from the List
	 * @param item the item to remove
	 */
	public void removeItem(String item)
	{
		if(mCount == 0)
		{
			System.out.println("List Empty");
			return;
		}
		
		Node removeNode = find(item);
		if (removeNode == null)
		{
			System.out.println("Item not found");
		}
		else
		{
			removeNode.mPrev.mNext = removeNode.mNext;
			removeNode.mNext.mPrev = removeNode.mPrev;
			mCount--;
		}	
	}
	
	/**
	 * Print title on a line by itself
	 * Prints the List from front to rear with 1 space between each item
	 * @param title the description of the List
	 */
	public void print(String title)
	{
		System.out.println('\n' + title);
		for(Node n = mFront.mNext; n != mRear; n=n.mNext)
		{
			System.out.print(n.mData + " ");
		}
		
		System.out.println();
	}
	
	/**
	 * Print title on a line by itself
	 * Prints the Sorted List with 1 space between each item
	 * Does not alter the List
	 * @param title the description of the List
	 */
	public void printSorted(String title)
	{
		ArrayList<String> list = new ArrayList<String>();
		for(Node n = mFront.mNext; n != mRear; n=n.mNext)
		{
			list.add(n.mData);
		}
		
		Collections.sort(list);
		
		System.out.println("\n" + title);
		for(String s: list)
		{
			System.out.print(s + " ");
		}
		
		System.out.println();	
	}
	
	//private method
	private Node find(String data){
		for(Node n = mFront.mNext; n != mRear; n=n.mNext)
		{
			if(n.mData.equals(data))
			{
				return n;
			}
		}
		return null;
	}
	
	//Class variables
	private int mCount;
	private Node mFront;
	private Node mRear;
	
	private class Node
	{
		public Node(String data)
		{
			mData = data;
			mPrev = mNext = null;
		}
		private String mData;
		private Node mPrev;
		private Node mNext;
	}
}