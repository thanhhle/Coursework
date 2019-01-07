public class Node
{
	public Node()
	{
		this(0);
	}
	
	public Node(int value)
	{
		data = value;
		startTime = endTime = distance = 0;
		parent = null;
	}
	
	public String toString()
	{
		return Integer.toString(data);
	}

	public int data;
	public int startTime;
	public int endTime;
	public Node parent;
	public int distance;
}
