//Thanh Le, 015809792, Assignment Nine
/**
 * 
 * @author Thanh Le
 * 
 * Binary Search Tree
 *
 */
public class BST {
	/**
	 * Create an empty BST
	 */
	public BST()
	{
		mRoot = new Node("");
	}
	
	/**
	 * Insert a node to the BST with the key as the data
	 * @param key the data of node to be inserted
	 */
	public void insert(String key)
	{
		if(key == null | key.length() < 1)	return;
		mRoot.insert(key);
	}

	/**
	 * Test if a node with the key as the data is in the BST
	 * @param key the data of the node to be tested the presentation
	 * @return true if a node with the given data is in the BST, false if otherwise
	 */
	public boolean isPresent(String key)
	{
		if(mRoot.mRight == null)	return false;
		return mRoot.isPresent(key);
	}

	/**
	 * Print out the BST in order: PREORDER, INORDER, or POSTORDER
	 * @param type the order of the BST (PREORDER, INORDER, or POSTORDER)
	 */
	public void traverse(TraversalType type)
	{
		mRoot.traverse(type);
	}

	/**
	 * Return the number of nodes in BST
	 * @return the number of nodes in BST
	 */
	public int getCount()
	{
		if(mRoot.mRight == null)	return 0;
		return mRoot.mRight.getCount();
	}
	
	/**
	 * Remove a node from the BST with the key as the data. Do nothing if the node is not in the BST
	 * @param key the data of the node to be removed
	 */
	public void remove(String key)
	{
		if(mRoot == null || !mRoot.isPresent(key))	return;
		mRoot.remove(key);
	}
	
	public static enum TraversalType { PREORDER, INORDER, POSTORDER };
	
	private Node mRoot;
	
	
	private class Node
	{
		private Node(String data)
		{
			mData = data;
			mLeft = mRight = mParent = null;
		}
		
		private void insert(String key)
		{
			if(key.compareTo(mData) < 0)
			{
				if(mLeft == null)
				{
					mLeft = new Node(key);
					mLeft.mParent = this;
					return;
				}
				else	mLeft.insert(key);
			}
			else
			{
				if(mRight == null)
				{
					mRight = new Node(key);
					mRight.mParent = this;
				}
				else	mRight.insert(key);
			}
		}
		
		private boolean isPresent(String key)
		{
			
			if (key.compareTo(mData) < 0)
			{
				if(mLeft == null)	return false;
				else 	return mLeft.isPresent(key);
			}
			else if(key.compareTo(mData) > 0)
			{
				if(mRight == null)	return false;
				else 	return mRight.isPresent(key);
			}
			return false;
		}
	
		private void traverse(TraversalType type)
		{
			if(type == TraversalType.PREORDER)
			{
				System.out.println("\n" + "PREORDER tree traversal");
				printPREORDER(this);
			}
			
			if(type == TraversalType.INORDER)
			{
				System.out.println("\n" + "INORDER tree traversal");
				printINORDER(this);
			}
			
			if(type == TraversalType.POSTORDER)	
			{
				System.out.println("\n" + "POSTORDER tree traversal");
				printPOSTORDER(this);
			}

			System.out.println();
		}
		
		private int getCount()
		{
			return ( (mLeft == null) ? 0 : (1 + mLeft.getCount()) ) + ( (mRight == null) ? 0 : (1 + mRight.getCount()) );
		}
		
		private void remove(String key)
		{
			if(key.compareTo(mData) < 0)
			{
				mLeft.remove(key);
			}
			else if(key.compareTo(mData) > 0)
			{
				mRight.remove(key);
			}
			else
			{
				if(mLeft == null && mRight == null)
				{
					if(mData.compareTo(mParent.mData) < 0)		
					{
						mParent.mLeft = null;
					}
					else
					{
						mParent.mRight = null;
					}
				}
				else if(mLeft == null)
				{
					if(mData.compareTo(mParent.mData) < 0)
					{
						mParent.mLeft = mRight;
						mLeft.mParent = mParent;
					}
					else
					{
						mParent.mRight = mRight;
						mRight.mParent = mParent;
					}
				}
				else if(mRight == null)
				{
					if(mData.compareTo(mParent.mData) < 0)
					{
						mParent.mLeft = mLeft;
						mLeft.mParent = mParent;
					}
					else
					{
						mParent.mRight = mLeft;
						mRight.mParent = mParent;
					}
				}
				else
				{
					String temp = findMaxFrom(mLeft).mData;
					remove(temp);
					mData = temp;
				}
			}
		}
		
		private void printPREORDER(Node node)
		{
			if(node != null)
			{
				System.out.print(node.mData + " ");
				printPREORDER(node.mLeft);
				printPREORDER(node.mRight);
			}
		}
		
		private void printINORDER(Node node)
		{
			if(node != null)
			{
				printINORDER(node.mLeft);
				System.out.print(node.mData + " ");
				printINORDER(node.mRight);
			}
		}
		
		private void printPOSTORDER(Node node)
		{
			if(node != null)
			{
				printPOSTORDER(node.mLeft);
				printPOSTORDER(node.mRight);
				System.out.print(node.mData + " ");
			}	
		}
		
		private Node findMaxFrom(Node currentNode)
		{
			if(currentNode.mRight == null)	return currentNode;
			else	return findMaxFrom(currentNode.mRight);
		}
		
		
		private Node mLeft;
		private Node mRight;
		private Node mParent;
		private String mData;
	}
}
