import java.util.Scanner;

public class script_L6
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		BST tree = new BST();
		
		System.out.print("Nodes in the BST: ");
		int k = 10;
		for(int i = 0; i < k; i++)
		{
			int randNum = (int)(Math.random()*50);
			System.out.print(randNum + " ");
			tree.insert(randNum);
		}
		
		System.out.println();
		
		System.out.print("BST: ");
		tree.tree_walk();

		System.out.println("\n\nPick a random node");
		System.out.println("Successor: " + tree.find_successor(input.nextInt()));
	}

}
