public class Node 
{
	public Node(int data)
	{
		mData = data;
		mLeft = mRight = mParent = null;
	}
	
	public void insert(int value)
	{
		if(value <= mData)
		{
			if(mLeft == null)
			{
				mLeft = new Node(value);
				mLeft.mParent = this;
				return;
			}
			else	mLeft.insert(value);
		}
		else
		{
			if(mRight == null)
			{
				mRight = new Node(value);
				mRight.mParent = this;
			}
			else	mRight.insert(value);
		}
	}
	
	public void tree_walk()
	{
		if(mLeft != null)		mLeft.tree_walk();
		System.out.print(mData + " ");
		if(mRight != null)		mRight.tree_walk();
	}
	
	public Node findMin()
	{
		if(mLeft == null)		return this;
		else					return mLeft.findMin();
	}
	
	public Node getNode(int value)
	{
		if (value < mData)
		{
			if(mLeft == null)		return null;
			else 					return mLeft.getNode(value);
		}
		else if(value > mData)
		{
			if(mRight == null)		return null;
			else 					return mRight.getNode(value);
		}
		else						return this;
	}
	
	public Node find_successor(int value)
	{
		Node node = getNode(value);
		if(node.mRight != null)		return node.mRight.findMin();
		else
		{
			while(node.mParent != mRoot && node.mData > node.mParent.mData)
			{
				node = node.mParent;
			}
			return node.mParent;
		}
	}
	
	public String toString()
	{
		return Integer.toString(mData);
	}
	
	private Node mLeft;
	private Node mRight;
	private Node mParent;
	private int mData;
}
