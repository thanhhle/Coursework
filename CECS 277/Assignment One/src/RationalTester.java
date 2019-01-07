/**
* class RationalTest to test the class Rational
* <p>
* @author Test
* @version 1.0
* @Fall 2017
*/
public class RationalTester {

	/**
	* main method used to test all the methods of class Rational 
	* @param args - unused
	*/
	public static void main(String[] args) {
		Rational R1 = new Rational();
		Rational R2 = new Rational();
		System.out.println("Input values for R1");
		R1.inputRational();
		System.out.println("Input values for R2");
		R2.inputRational();

		Rational R3 = new Rational();
		R3.add(R1, R2);
		System.out.println(R1 + " + " + R2 + " = " + R3);

		R3 = R1.sub(R2);
		System.out.println(R1 + " - " + R2 + " = " + R3);

		R3.mul(R1, R2);
		System.out.println(R1 + " * " + R2 + " = " + R3);

		R3 = R1.div(R2);
		System.out.println(R1 + " / " + R2 + " = " + R3);

		System.out.println(Rational.divToDouble(R1, R2));

		R1.setNumerator(2);
		R2.setDenominator(5);
		System.out.println("R1 Numerator: " + R1.getNumerator());
		System.out.println("R2 Denominator: " + R2.getDenominator());
	}
}


/*
//Thanh Le, 015809792, RationalTester
/**
 * 
 * @author Thanh Le
 * 
 * Tester for Rational class
 *

public class RationalTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Rational R1 = new Rational();
		Rational R2 = new Rational();
		Rational R3 = new Rational();
		
		//1. Input Rational object  R1
		System.out.println("Input Rational object R1");
		R1.inputRational();
		
		//2. Input Rational object  R2
		System.out.println("Input Rational object R2");
		R2.inputRational();

		//3. Add the Rational objects R1 and R2 and store the result in the Rational object R3
		R3.add(R1, R2);
		System.out.println(R1.toString() + " + " + R2.toString() + " = " + R3.toString());
		
		//4. Subtract the Rational object R2 from the Rational object R1 and store the result in the Rational object R3
		R3 = R1.sub(R2);
		System.out.println(R1.toString() + " - " + R2.toString() + " = " + R3.toString());
		
		//5. Multiply the Rational object R1 with the Rational object R2 and store the result in the object R3
		R3.mul(R1, R2);
		System.out.println(R1.toString() + " * " + R2.toString() + " = " + R3.toString());
		
		//6. Divide the Rational object R1 by the Rational object R2 and store the result in the object R3
		R3 = R1.div(R2);
		System.out.println(R1.toString() + " / " + R2.toString() + " = " + R3.toString());
		
		//7. Display the result of dividing the object R1 by the object R2 in a real number
		System.out.println(Rational.divToDouble(R1, R2));
		
		//8. Change the numerator of object R1 to 2
		R1.setNumerator(2);
		
		//9. Change the denominator of object R2 to 5
		R2.setDenominator(5);
		
		//10. Display the numerator of R1 and the denominator of R2
		System.out.println("Numerator: " + R1.getNumerator());
		System.out.println("Denominator: " + R2.getDenominator());
	}
}
*/
