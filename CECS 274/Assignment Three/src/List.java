import java.util.ArrayList;
import java.util.Collections;
//Thanh Le, 015809792, Assignment Three
/**
 * 
 * @author Thanh Le
 * 
 * A simple List class
 *
 */
public class List {
	/**
	 * Create a List with the indicated size
	 * @param size the maximum number of items in the List
	 */
	public List(int size)
	{
		mList = new String[size];
		mCount = 0;
	}
	
	/**
	 * If the List is not full, item becomes the new front element
	 * If the List is full, prints "List Full"
	 * @param item the item to add
	 */
	public void addToFront(String item)
	{
		if(mCount == mList.length)
		{
			System.out.println("List Full");
		}
		else
		{
			shiftToRight(0);
			mList[0] = item;
			mCount++;
		}
		
	}
	
	/**
	 * If the List is not full, item becomes the new rear element
	 * If the List is full, prints "List Full"
	 * @param item the item to add
	 */
	public void addToRear(String item)
	{
		if(mCount == mList.length)
		{
			System.out.println("List Full");
		}
		else
		{
			mList[mCount] = item;
			mCount++;
		}
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
		if(mCount == mList.length)
		{
			System.out.println("List Full");
		}
		else
		{
			if(indexOf(beforeItem) == -1)
			{
				System.out.println("Item not found");
			}
			else
			{
				int indexBeforeItem = indexOf(beforeItem);
				shiftToRight(indexBeforeItem);
				mList[indexBeforeItem] = item;		 
				mCount++;
			}
		}
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
		if(askCount() == mList.length)
		{
			System.out.println("List Full");
		}
		else
		{
			if(indexOf(afterItem) == -1)
			{
				System.out.println("Item not found");
			}
			else
			{
				int indexAfterItem = indexOf(afterItem);
				shiftToRight(indexAfterItem);
				mList[indexAfterItem + 1] = item;
				mCount++;
			}
		}
	}
	
	/**
	 * Returns the item at the front of the List
	 * List is not altered
	 * @return the item at the front of the List
	 */
	public String getFront()
	{
		return mList[0];
	}

	/**
	 * Returns the item at the rear of the List 
	 * List is not altered
	 * @return the item at the rear of the List
	 */
	public String getRear()
	{
		return mList[mCount-1];
	}
	
	/**
	 * Return true if item is in List, false otherwise
	 * @param item item to check presence in List
	 * @return true if item is in List, false otherwise
	 */
	public boolean isPresent(String item)
	{
		for(int ii = 0; ii < mCount; ii++)
		{
			if(mList[ii] != null && mList[ii].equals(item))
			{
				return true;
			}
		}
		return false;
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
			shiftToLeft(0);
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
		}
		else
		{
			if(!isPresent(item))
			{
				System.out.println("Item not found");
			}
			else
			{		
				shiftToLeft(indexOf(item));
				mCount--;
			}
		}
	}
	
	/**
	 * Print title on a line by itself
	 * Prints the List from front to rear with 1 space between each item
	 * @param title the description of the List
	 */
	public void print(String title)
	{
		System.out.println("\n" + title);
		for(int ii = 0; ii < mCount; ii++)
		{
			if(mList[ii] != null)
			{
				System.out.print(mList[ii] + " ");
			}
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
		for(int ii = 0; ii < mCount; ii++)
		{
			if(mList[ii] != null)
			{
				list.add(mList[ii]);
			}
		}
		
		Collections.sort(list);
		
		System.out.println("\n" + title);
		for(String s: list)
		{
			if(s != null)
			{
				System.out.print(s + " ");
			}
		}
		System.out.println();
	}
	
	//Private methods
	private int indexOf(String item)
	{
		for(int ii = 0; ii < mCount; ii++)
		{
			if(mList[ii] != null && mList[ii].equals(item))
			{
				return ii;
			}
		}
		return -1;
	}
	
	private void shiftToRight(int fromIndex)
	{
		for(int ii = mCount-1; ii > fromIndex-1; ii--)
		{   
		    mList[ii+1] = mList[ii];
		}
	}
	
	private void shiftToLeft(int fromIndex)
	{
		for(int ii = fromIndex; ii < mCount-1; ii++)
		{   
		    mList[ii] = mList[ii+1];
		}
	} 
	
	//Class variables
	private String[] mList;
	private int mCount;
}