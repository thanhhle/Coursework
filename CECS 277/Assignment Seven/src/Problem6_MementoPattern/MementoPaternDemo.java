package Problem6_MementoPattern;

public class MementoPaternDemo 
{
	public static void main(String[] args) 
	{	
		Calculator cal = new Calculator();
		CalculationCareTaker careTaker = new CalculationCareTaker();
		
		int num1 = 2;
		int num2 = 3;
		cal.setTwoNumbers(num1, num2);
		careTaker.add(cal.backUpLastCalculation());
		
		num1 = 5;
		num2 = 6;
		cal.setTwoNumbers(num1, num2);
		careTaker.add(cal.backUpLastCalculation());
		
		MementoCalculator mem = careTaker.get(0);
		cal.restorePreviousCalculator(mem);
		System.out.println(mem.getNum1() + " + " + mem.getNum2() + " = " + cal.addTwoNumbers());
		
		mem = careTaker.get(1);
		cal.restorePreviousCalculator(mem);
		System.out.println(mem.getNum1() + " + " + mem.getNum2() + " = " + cal.addTwoNumbers());
	}
}
