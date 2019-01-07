public class AVL 
{
	public AVL()
	{
		mRoot = null;
	}
	
	public AVL(int arr[])
	{
		if(arr.length == 0)		new AVL();
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
	
	private Node mRoot;
}
