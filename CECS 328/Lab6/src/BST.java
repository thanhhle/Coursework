public class BST 
{	
	public BST()
	{
		mRoot = null;
	}
	
	public BST(int arr[])
	{
		if(arr.length == 0)		new BST();
		else
		{
			mRoot = new Node(arr[0]);
			for(int i = 1; i < arr.length; i++)
			{
				mRoot.insert(arr[i]);
			}
		}
	}
	
	public void insert(int value)
	{
		if(mRoot == null)	mRoot = new Node(value);
		else				mRoot.insert(value);
	}

	public void tree_walk()
	{
		if(mRoot == null)	return;
		else				mRoot.tree_walk();
	}
	
	public Node find_successor(int value)
	{
		if(mRoot == null)	return null;
		else				return mRoot.find_successor(value);
	}
	
	
	private Node mRoot;
	
	private class Node 
	{
		private Node(int data)
		{
			mData = data;
			mLeft = mRight = mParent = null;
		}
		
		private void insert(int value)
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
		
		private void tree_walk()
		{
			if(mLeft != null)		mLeft.tree_walk();
			System.out.print(mData + " ");
			if(mRight != null)		mRight.tree_walk();
		}
		
		private Node findMin()
		{
			if(mLeft == null)		return this;
			else					return mLeft.findMin();
		}
		
		private Node getNode(int value)
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
		
		private Node find_successor(int value)
		{
			Node node = getNode(value);
			if(node == null)			return node;
			if(node.mRight != null)		return node.mRight.findMin();
			else
			{
				while(node.mParent != mRoot && node.mData > node.mParent.mData) // loop until it is left node
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

}
