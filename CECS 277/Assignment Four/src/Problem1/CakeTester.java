package Problem1;

import java.util.Scanner;

public class CakeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String choice = input.next();
		CakeFactory cf = new CakeFactory();
		Cake c = cf.createCake(choice);
		
		c.aboutCake();
	}
}
