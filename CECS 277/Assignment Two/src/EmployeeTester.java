import java.util.Arrays;
import java.util.GregorianCalendar;

public class EmployeeTester{

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Employee[] employees = new Employee[9];
		employees[0] = new Staff(	"Allen", 		"Paita", 		"123", 		'M', 	new GregorianCalendar(59,  2, 23), 		50.00);
		employees[1] = new Staff(	"Zapata", 		"Steven", 		"456", 		'F', 	new GregorianCalendar(64,  7, 12), 		35.00);
		employees[2] = new Staff(	"Rios", 		"Enrique", 		"789", 		'M', 	new GregorianCalendar(70,  6, 2 ), 		40.00);
		employees[3] = new Faculty(	"Johnson", 		"Anne", 		"243", 		'F', 	new GregorianCalendar(62,  4, 27), 		Faculty.Level.FU, 		new Education("Ph.D", "Engineering", 3));
		employees[4] = new Faculty(	"Bouris", 		"William", 		"791", 		'F', 	new GregorianCalendar(75,  3, 14), 		Faculty.Level.AO, 		new Education("Ph.D", "English", 1));
		employees[5] = new Faculty(	"Andrade",		"Christopher", 	"623", 		'F', 	new GregorianCalendar(80,  5, 22), 		Faculty.Level.AS, 		new Education("MS", "Physical Education", 0));
		employees[6] = new Partime(	"Guzman", 		"Augusto",		"455", 		'F', 	new GregorianCalendar(77,  8, 10), 		35.00, 			30);
		employees[7] = new Partime(	"Depirro", 		"Martin", 		"678", 		'F', 	new GregorianCalendar(87,  9, 15), 		30.00, 			15);
		employees[8] = new Partime(	"Aldaco", 		"Marque", 		"945", 		'M', 	new GregorianCalendar(88, 11, 24), 		20.00, 			35);
	
		//Display Employee information
		System.out.println("Display all employee information");
		display(employees);
		
		System.out.println("\n" + "***************************************************************************");
		

		//Total monthly salary for all the part-time staff
		double totalMonthlySalaryPartTime = 0.0;
		for(Employee e : employees)
		{
			if(e instanceof Partime)
			{
				totalMonthlySalaryPartTime = totalMonthlySalaryPartTime + e.monthlyEarning();
			}
		}
		System.out.println("Total monthly salary for all the part-time staff: $" + totalMonthlySalaryPartTime + "\n");
		
		System.out.println("***************************************************************************");
		
		
		//Total monthly salary for all employees
		double totalMonthlySalary = 0.0;
		for(Employee e : employees)
		{
			totalMonthlySalary = totalMonthlySalary + e.monthlyEarning();
		}
		System.out.println("Total monthly salary for all employees: $" + totalMonthlySalary + "\n");
		
		System.out.println("***************************************************************************");
		
		
		//Display all employee information descending by employee id using interface Comparable
		System.out.println("Display all employee information descending by employee id using interface Comparable");
		Arrays.sort(employees);
		display(employees);
		
		System.out.println("***************************************************************************");
		
		
		//Display all employee information ascending by last name using interface Comparator
		System.out.println("Display all employee information ascending by last name using interface Comparator");
		Arrays.sort(employees, new LastNameComparator());
		display(employees);
		
		System.out.println("***************************************************************************");
		
		
		//Duplicate a faculty object using clone. Verify the duplication.
		System.out.println("Duplicate a faculty object using clone");
		System.out.println("The Faculty to be duplicated: ");
		System.out.println(employees[3].toString());
		System.out.println("\n" + "The duplicated Faculty: ");
		Faculty copyFaculty = (Faculty)employees[3].clone();
		System.out.println(copyFaculty.toString());
	}
	
	public static void display(Employee[] array)
	{
		String currentClass = array[0].getClass().getName();
		currentClass = array[0].getClass().getName();
		System.out.println(currentClass);
		for(Employee e : array)
		{
			if(!currentClass.equals(e.getClass().getName()))
			{
				currentClass = e.getClass().getName();
				System.out.println(currentClass);
				System.out.println("----------------------------------");
			}
			System.out.println(e.toString());
			System.out.println();
		}
	}
}