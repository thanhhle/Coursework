import java.util.LinkedList;
import java.util.Scanner;

public class script_L7
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the order:");
		int order = input.nextInt();
		System.out.println("Enter the number of edges:");
		int edges = input.nextInt();

		int[][] adjMat = generateRandomAdjacencyMatrix(order, edges);
		printAdjacencyMatrix(adjMat);
		Graph g = new Graph(adjMat);
		
		System.out.println("\nEnter the vertex you want to run the BFS and DFS from: ");
		int vertex = input.nextInt();
		
		
		System.out.println("\n-------------------------------------- BFS -----------------------------------------");
		LinkedList<Node> reachableVerticesBFS = g.bfs(vertex);
		
		// Display reachable vertices using BFS
		System.out.println("Vertices reachable from vertex " + vertex + ":");
		for(int i = 1; i < reachableVerticesBFS.size(); i++)
		{
			System.out.print(reachableVerticesBFS.get(i) + " ");
		}
						
		System.out.println();
				
		// Display shortest path and distance to each reachable vertex using BFS
		for(int i = 1; i < reachableVerticesBFS.size(); i++)
		{
			LinkedList<Node> path = new LinkedList<Node>();
			Node current = reachableVerticesBFS.get(i);
			while(current.data != vertex)
			{
				path.addFirst(current);
				current = current.parent;
			}
					
			System.out.println("\nShortest path from " + vertex + " to " + (reachableVerticesBFS.get(i)));
			System.out.print(vertex + " ");
			for(Node n : path)
			{
				System.out.print(n.data + " ");
			}
			System.out.println("\nDistance: " + reachableVerticesBFS.get(i).distance);
		}
		
		
		
		
		System.out.println("\n-------------------------------------- DFS -----------------------------------------");
		
		// Display reachable vertices using DFS
		System.out.println("Vertices reachable from vertex " + vertex + ":");
		LinkedList<Node> reachableVerticesDFS = g.dfs_visit(vertex, new LinkedList<Node>());
		for(int i = 1; i < reachableVerticesDFS.size(); i++)
		{
			Node n = reachableVerticesDFS.get(i);
			System.out.println("V" + n + " (startTime: " + n.startTime + ", endTime: " + n.endTime + ")");
		}
		
		// Run DFS function to check if the graph is a DAG (directed acyclic graph)
		System.out.println("\nRun DFS function to check if the graph is a DAG (directed acyclic graph):");
		LinkedList<Node> pathDFS_g = g.dfs();
		if(!g.hasCycle)
		{
			for(int i = 0; i < pathDFS_g.size(); i++)
			{
				Node n = pathDFS_g.get(i);
				System.out.println("V" + n + " (startTime: " + n.startTime + ", endTime: " + n.endTime + ")");
			}
		}
		
		
		System.out.println("\n-------------------------------------- DAG -----------------------------------------");
		int[][] adjMatDAG = {	{0, 1, 1, 1, 1},
								{0, 0, 0, 1, 0},
								{0, 0, 0, 1, 1},
								{0, 0, 0, 0, 1},
								{0, 0, 0, 0, 0}		};
		Graph dag = new Graph(adjMatDAG);

		printAdjacencyMatrix(adjMatDAG);
		System.out.println();
		
		// Run DFS function to check if the graph is a DAG (directed acyclic graph)
		LinkedList<Node> pathDFS_dag = dag.dfs();
		System.out.println("Topological Order:");
		if(!dag.hasCycle)	
		{
			for(int i = 0; i < pathDFS_dag.size(); i++)
			{
				Node n = pathDFS_dag.get(i);
				System.out.println("V" + n + " (startTime: " + n.startTime + ", endTime: " + n.endTime + ")");
			}
		}
	}

	public static int[][] generateRandomAdjacencyMatrix(int order, int edges)
	{	
		int[][] adjMat = new int[order][order];
		
		for(int i = 0; i < edges; i++)
		{
			int randRow = (int)(Math.random()*order);
			int randCol = (int)(Math.random()*order);
			
			while(randRow == randCol || adjMat[randRow][randCol]!= 0)
			{
				randRow = (int)(Math.random()*order);
				randCol = (int)(Math.random()*order);
			}
			adjMat[randRow][randCol] = 1;	
		}
		return adjMat;
	}
	
	public static void printAdjacencyMatrix(int[][] adjMat)
	{
		for(int i = 1; i <= adjMat.length; i++)
		{
			System.out.print("\tV" + i);
		}
		System.out.println("");
		
		for(int i = 0; i < adjMat.length; i++)
		{
			System.out.print("V" + (i+1) + "\t");
		    for(int j = 0; j < adjMat[0].length; j++)
		    {
		        System.out.print(adjMat[i][j] + "\t");
		    }
		    System.out.println("");
		}
	}
}