import java.util.ArrayList;
import java.util.Collections;
//Thanh Le, 015809792, Assignment Five
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
		mList = new ArrayList<String>();
	}

	/**
	 * Create a List with the items in the input list.
	 * @param list the List to duplicate 
	 */
	public List(List list)
	{	
		this();
		int mCount = list.askCount();
		for(int ii = 0; ii < mCount; ii++)
		{
			String s = list.getFront();
			addToRear(s);
			list.removeFront();
			list.addToRear(s);
		}
	}
		

	/**
	 * If the List is not full, item becomes the new front element
	 * If the List is full, prints "List Full"
	 * @param item the item to add
	 */
	public void addToFront(String item)
	{
		mList.add(0, item);
	}
	
	/**
	 * If the List is not full, item becomes the new rear element
	 * If the List is full, prints "List Full"
	 * @param item the item to add
	 */
	public void addToRear(String item)
	{
		mList.add(item);
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
		if(mList.indexOf(beforeItem) == -1)
		{
			System.out.println("Item Not Found");
		}
		else
		{
			mList.add(mList.indexOf(beforeItem), item);
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
		if(mList.indexOf(afterItem) == -1)
		{
			System.out.println("Item Not Found");
		}
		else
		{
			mList.add(mList.indexOf(afterItem)+1, item);
		}
	}
	
	/**
	 * Returns the item at the front of the List
	 * List is not altered
	 * @return the item at the front of the List
	 */
	public String getFront()
	{
		return mList.get(0);
	}

	/**
	 * Returns the item at the rear of the List 
	 * List is not altered
	 * @return the item at the rear of the List
	 */
	public String getRear()
	{
		return mList.get(mList.size()-1);
	}
	
	/**
	 * Return true if item is in List, false otherwise
	 * @param item item to check presence in List
	 * @return true if item is in List, false otherwise
	 */
	public boolean isPresent(String item)
	{
		return mList.contains(item);
	}
	
	/**
	 * Returns the number of items in the List
	 * @return the number of items in the List
	 */
	public int askCount()
	{	
		return mList.size();
	}
	
	/**
	 * If the List is empty, prints "List Empty"
	 * If the List is not empty, removes the item at the front of the List
	 */
	public void removeFront()
	{
		if(mList.size() == 0)
		{
			System.out.println("List Empty");
		}
		else
		{
			mList.remove(0);
		}
	}
	
	/**
	 * If the List is empty, prints "List Empty"
	 * If the List is not empty, removes the item at the rear of the List
	 */
	public void removeRear()
	{
		if(mList.size() == 0)
		{
			System.out.println("List Empty");
		}
		else
		{
			mList.remove(mList.size()-1);
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
		if(mList.size() == 0)
		{
			System.out.println("List Empty");
		}
		else if(!mList.contains(item))
		{
			System.out.println("Item not found");
		}
		else
		{
			for(int ii = 0; ii < mList.size(); ii++)
			{
				if(mList.get(ii).equals(item))
				{
					mList.remove(ii);
				}
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
		System.out.println('\n' + title);
		for(int ii = 0; ii < mList.size(); ii++)
		{
			System.out.print(mList.get(ii) + " ");
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
		System.out.println('\n' + title);
		ArrayList<String> copyList = new ArrayList<String>(mList);
	
		Collections.sort(copyList);
		
		for(int ii = 0; ii < copyList.size(); ii++)
		{
			System.out.print(copyList.get(ii) + " ");
		}
		System.out.println();
	}
	
	//Class variables
	private ArrayList<String> mList;
}