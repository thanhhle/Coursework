import java.util.LinkedList;

public class Queue {
	public Queue()
	{
		mQueue = new LinkedList<Node>();
	}
	
	public void push(Node num)
	{
		mQueue.add(num);
	}
	
	public Node pop()
	{
		Node n = mQueue.get(0);
		mQueue.remove(0);
		return n;
	}
	
	public boolean isEmpty()
	{
		return mQueue.size() == 0;
	}
	
	private LinkedList<Node> mQueue;
}
