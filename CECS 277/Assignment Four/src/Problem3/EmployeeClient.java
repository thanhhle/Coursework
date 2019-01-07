package Problem3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class EmployeeClient {

	public static void main(String[] args) throws FileNotFoundException, CloneNotSupportedException {
		Scanner inputStaff = new Scanner(new FileReader("inputStaff.txt"));
		Scanner inputFaculty = new Scanner(new FileReader("inputFaculty.txt"));
		Scanner inputPartime = new Scanner(new FileReader("inputPartime.txt"));
		
		EmployeeFactory factory = new EmployeeFactory();
		Employee[] employees = new Employee[9];
		employees[0] = factory.createEmployee(EmployeeFactory.Type.STAFF);
		employees[1] = factory.createEmployee(EmployeeFactory.Type.STAFF);
		employees[2] = factory.createEmployee(EmployeeFactory.Type.STAFF);
		employees[3] = factory.createEmployee(EmployeeFactory.Type.FACULTY);
		employees[4] = factory.createEmployee(EmployeeFactory.Type.FACULTY);
		employees[5] = factory.createEmployee(EmployeeFactory.Type.FACULTY);
		employees[6] = factory.createEmployee(EmployeeFactory.Type.PARTIME);
		employees[7] = factory.createEmployee(EmployeeFactory.Type.PARTIME);
		employees[8] = factory.createEmployee(EmployeeFactory.Type.PARTIME);

		for(Employee e: employees)
		{
			String type = e.getClass().getSimpleName();
			if(type.equalsIgnoreCase("Staff"))				e.inputEmployee(inputStaff);
			else if(type.equalsIgnoreCase("Faculty"))		e.inputEmployee(inputFaculty);
			else if(type.equalsIgnoreCase("Partime"))		e.inputEmployee(inputPartime);
		}
		
		inputStaff.close();
		inputFaculty.close();
		inputPartime.close();
		
		//Display Employee information
		System.out.println("Display all employee information");
		display(employees);
				
		System.out.println("\n" + "***************************************************************************");
				

		//Total monthly salary for all the part-time staff
		double totalMonthlySalaryPartTime = 0.0;
		for(Employee e : employees)
		{
			if(e.getClass().getSimpleName().equalsIgnoreCase("Partime"))
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
		String currentClass = array[0].getClass().getSimpleName();
		System.out.println(currentClass);
		for(Employee e : array)
		{
			if(!currentClass.equals(e.getClass().getSimpleName()))
			{
				currentClass = e.getClass().getSimpleName();
				System.out.println(currentClass);
				System.out.println("----------------------------------");
			}
			System.out.println(e.toString());
			System.out.println();
		}
	}
}
