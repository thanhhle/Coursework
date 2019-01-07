import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

//Thanh Le, 015809792, Assignment Six
/**
 * 
 * @author Thanh Le
 * 
 * Main Program - Assignment Six
 *
 */
public class AssignmentSix
{
	public static void main(String[] args) throws FileNotFoundException
	{
		
		Stack mStack = new Stack();
		Scanner sc = new Scanner(new FileReader(args[0]));
		
		while(sc.hasNextLine())
		{
			String line = sc.nextLine();
			sop("Expression: " + line);
			
			String[] tokens = line.split(" ");
			
			for(int ii = 0; ii < tokens.length; ii++)
			{
				if(isBinaryOperator(tokens[ii]))
				{
					evaluateBinaryOperator(mStack, tokens[ii]);	
				}
				
				else if(isUnaryOperator(tokens[ii]))
				{
					evaluateUnaryOperator(mStack, tokens[ii]);
				}
				
				else	
				{
					mStack.push(tokens[ii]);
				}
			}
			
			sop("Value: " + mStack.getTop());	
			mStack.pop();
		}
		sc.close();
		
	}	
	
	
	private static boolean isBinaryOperator(String s)
	{
		return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
	}
	
	private static boolean isUnaryOperator(String s)
	{
		return (s.equals("sin") || s.equals("cos") || s.equals("tan"));
	}
	
	private static void evaluateBinaryOperator(Stack mStack, String token)
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
		else if(token.equals("*"))
		{
			result = op1 * op2;
		}
		else if(token.equals("/"))
		{
			result = op1 / op2;
		}
	
		mStack.push(String.valueOf(result));
	}
	
	private static void evaluateUnaryOperator(Stack mStack, String token)
	{
		String operand = mStack.getTop();
		mStack.pop();
		
		double op = Double.parseDouble(operand);
		double result = 0.0;
		
		if(token.equals("sin"))
		{
			result = Math.sin(Math.toRadians(op));
		}
		else if(token.equals("cos"))
		{
			result = Math.cos(Math.toRadians(op));
		}
		else if(token.equals("tan"))
		{
			result = Math.tan(Math.toRadians(op));
		}
		
		mStack.push(String.valueOf(result));
	}
	
	private static void sop(String s)
	{
		System.out.println(s);
	}
}