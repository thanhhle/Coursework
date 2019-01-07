import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

//Thanh Le, 015809792, Assignment Seven
/**
 * 
 * @author Thanh Le
 * 
 * Main Program - Assignment Seven
 *
 */
public class AssignmentSeven
{
	public static void main(String[] args) throws FileNotFoundException
	{
		
		Stack mStack = new Stack();
		Queue mQueue = new Queue();
		Scanner sc = new Scanner(new FileReader(args[0]));
		
		while(sc.hasNextLine())
		{
			String line = sc.nextLine();
			sop("Expression is: " + line);
			
			String[] tokens = line.split(" ");
			
			convertInfixToPostfix(mQueue, mStack, tokens);
			mQueue.dump("Postfix is");
			
			doCalculation(mQueue, mStack);
			sop("Value is " + mStack.getTop() + "\n");	
			
			mStack.pop();
		}
		sc.close();
	}	
	
	private static boolean isOperator(String s)
	{
		return (s.equals("+") || s.equals("-"));
	}
	
	private static void evaluateOperator(Stack mStack, String token)
	{
		String operand2 = mStack.getTop();
		mStack.pop();
		
		String operand1 = mStack.getTop();
		mStack.pop();
		
		double op1 = Double.parseDouble(operand1);
		double op2 = Double.parseDouble(operand2);
		double result = 0.0;
		
		if(token.equals("+"))
		{
			result = op1 + op2;
		}
		else if(token.equals("-"))
		{
			result = op1 - op2;
		}
	
		mStack.push(String.valueOf(result));
	}
	
	private static void convertInfixToPostfix(Queue mQueue, Stack mStack, String[] tokens)
	{
		for(int ii = 0; ii < tokens.length; ii++)
		{
			if(tokens[ii].equals("(") || isOperator(tokens[ii]))
			{
				mStack.push(tokens[ii]);	
			}
			
			else if(tokens[ii].equals(")"))
			{
				while(!mStack.getTop().equals("("))
				{
					String item = mStack.getTop();
					mQueue.add(item);
					mStack.pop();
				}
				mStack.pop();
			}
			
			else
			{
				mQueue.add(tokens[ii]);
			}
		}
	}
	
	private static void doCalculation(Queue mQueue, Stack mStack)
	{
		while(!mQueue.isEmpty())
		{
			String item = mQueue.remove();
			if(isOperator(item))
			{
				evaluateOperator(mStack, item);	
			}
			else
			{
				mStack.push(item);
			}
		}
	}
	
	private static void sop(String s)
	{
		System.out.println(s);
	}
}