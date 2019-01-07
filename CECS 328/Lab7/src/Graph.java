import java.util.LinkedList;

public class Graph
{
	public Graph(Graph g)
	{
		this(g.adjMat);
	}
	
	public Graph(int[][] adjMat)
	{
		this.adjMat = adjMat;
		nodes = new LinkedList<Node>();
		for(int i = 0; i < adjMat.length; i++)
		{
			nodes.add(new Node(i+1));
		}
		hasCycle = false;
		timer = 0;
	}
	
	public LinkedList<Node> bfs(int s)
	{
		Graph g = new Graph(this); 		// Don't want the original graph to be changed
		Queue q = new Queue();
		Node root = g.nodes.get(s-1);
		q.push(root);
		root.parent = new Node(-1);
		
		LinkedList<Node> reachableVertices = new LinkedList<Node>();
		while(!q.isEmpty())
		{
			Node current = q.pop();
			reachableVertices.add(current);
			LinkedList<Node> neighbors = g.getNeighbors(current.data);
			if(neighbors != null)
			{
				for(Node n : neighbors)
				{
					if(n.parent == null)
					{
						q.push(n);
						n.parent = current;
						n.distance = current.distance + 1;
					}	
				}
			}
		}
		
		return reachableVertices;
	}
	
	public LinkedList<Node> dfs()
	{
		LinkedList<Node> pathDFS = new LinkedList<Node>();
		for(Node n : nodes)
		{
			if(n.startTime == 0)
			{
				n.parent = new Node(-1);
				pathDFS = dfs_visit(n.data, pathDFS);
			}
		}
		
		if(hasCycle)
		{
			System.out.println("Cycle detected, topological sort is impossible");
			return null;
		}
		else	
		{
			return pathDFS;
		}
	}
	
	public LinkedList<Node> dfs_visit(int s, LinkedList<Node> reachableVertices)
	{
		Node v = nodes.get(s-1);
		v.startTime = ++timer;
		reachableVertices.add(v);
		LinkedList<Node> neighbors = getNeighbors(v.data);
		if(neighbors.size() > 0)
		{
			for(Node n: neighbors)
			{
				if(n.startTime == 0)
				{
					n.parent = v;
					reachableVertices = dfs_visit(n.data, reachableVertices);
				}
				else if(n.startTime != 0  && n.endTime == 0)
				{
					hasCycle = true;
					System.out.println("Cycle is detected at V" + v + " - V" + n);//break;
				}
			}
		}
		v.endTime = ++timer;
		return reachableVertices;
	}
	
 	private LinkedList<Node> getNeighbors(int v)
	{
		LinkedList<Node> neighbors = new LinkedList<Node>();
		for(int i = 0; i < adjMat[v-1].length; i++)
		{
			if(adjMat[v-1][i] != 0)
			{
				neighbors.add(nodes.get(i));
			}
		}
		return neighbors;
	}
	
		
	private LinkedList<Node> nodes;
	private int[][] adjMat;
	private int timer;
	public boolean hasCycle;
}
