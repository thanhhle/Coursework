package Problem1;

/**
This program tests the StudentReportCard class
*/
public class StudentReportCardTester {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Student student = new Student("Thanh", 19, "015809792");
		Class[] classes = new Class[4];
		classes[0] = new Class("PHYS 151", 94);
		classes[1] = new Class("MATH 123", 98);
		classes[2] = new Class("CECS 284", 91);
		classes[3] = new Class("CECS 100", 93);
		
		StudentReportCard card1 = new StudentReportCard(student, classes);
		
		System.out.println(card1.toString());
	}
	

}
