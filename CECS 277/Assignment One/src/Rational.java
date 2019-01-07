//Thanh Le, 015809792, Rational
import java.util.Scanner;
/**
 * 
 * @author Thanh Le
 * 
 * A Rational class for performing arithmetic operations with Rationals
 *
 */
public class Rational {
	/**
	 * Construct a Rational with default argument
	 */
	public Rational()
	{
		numerator = denominator = 0;
	}
	
	/**
	 * Construct a Rational with given numerator and denominator
	 * @param n numerator to be set to the Rational
	 * @param d denominator to be set to the Rational
	 */
	public Rational(int n, int d)
	{
		numerator = n;
		denominator = d;
		simplifyRational();
	}
	
	/**
	 * Return the numerator
	 * @return numerator
	 */
	public int getNumerator()
	{
		return numerator;
	}
	
	/**
	 * Return the denominator
	 * @return denominator
	 */
	public int getDenominator()
	{
		return denominator;
	}
	
	/**
	 * Set the numerator to value
	 * @param value the value to be set to the numerator
	 */
	public void setNumerator(int value)
	{
		numerator = value;
	}
	
	/**
	 * Set the denominator to value
	 * @param value the value to be set to the denominator
	 */
	public void setDenominator(int value)
	{
		denominator = value;
	}
	
	/**
	 * Input the numerator and the denominator from the keyboard
	 */
	public void inputRational()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Numerator: ");
		numerator = input.nextInt();
		System.out.println("Denominator: ");
		denominator = input.nextInt();
		simplifyRational();
	}
	
	/**
	 * Return a string in the form numerator/denominator
	 */
	public String toString()
	{
		return numerator + "/" + denominator;
	}
	
	/**
	 * Add two Rational numbers 
	 * @param r1 a rational number
	 * @param r2 a rational number
	 */
	public void add(Rational r1, Rational r2)
	{
		numerator = r1.numerator*r2.denominator + r2.numerator*r1.denominator;
		denominator = r1.denominator*r2.denominator;
		simplifyRational();
	}
	
	/**
	 * Subtract two Rational numbers
	 * @param r the Rational number to be subtracted
	 * @return the difference
	 */
	public Rational sub(Rational r)
	{
		int n = numerator*r.denominator - r.numerator*denominator;
		int d = denominator*r.denominator;
		Rational rational = new Rational(n, d);
		return rational;
	}
	
	/**
	 * Multiply two Rational numbers
	 * @param r1 a Rational number
	 * @param r2 a Rational number
	 */
	public void mul(Rational r1,Rational r2) 
	{
		denominator = r1.denominator * r2.denominator;
		numerator = r1.numerator * r2.numerator;
		simplifyRational();
	}
	
	/**
	 * Divide two Rational numbers
	 * @param r the Rational number to be divided
	 * @return the division
	 */
	public Rational div(Rational r) 
	{
		int n = numerator * r.denominator;
		int d = denominator * r.numerator;
		Rational rational = new Rational(n, d);
		return rational;
	}
	
	/**
	 * Return the real value of Rational r1 divided by Rational r2
	 * @param r1 a Rational number
	 * @param r2 a Rational number
	 * @return the real value of Rational r1 divided by Rational r2
	 */
	public static double divToDouble(Rational r1,Rational r2)
	{
		Rational r = r1.div(r2);
		return Double.valueOf(r.getNumerator())/Double.valueOf(r.getDenominator());
	}
	
	/**
	 * Return the greatest common divisor
	 * @param m an integer number
	 * @param n an integer number
	 * @return the greatest common divisor
	 */
	private int gcd(int m, int n)
	{
		int r;
		while(n != 0)
		{ 
			r = m % n;
			m = n;
			n = r;
		}
		return m;
	}
	
	/**
	 * Simplify a Rational
	 */
	private void simplifyRational()
	{
		int gcd = gcd(numerator, denominator);
		numerator = numerator/gcd;
		denominator = denominator/gcd;
	}
	
	private int numerator;
	private int denominator;
}
