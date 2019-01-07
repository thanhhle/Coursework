package Problem3;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Class Staff extending from the class Employee
 * <p>
 * @author Thanh Le
 * @version 1.0
 * @Fall 2017
 */
public class Staff extends Employee{
	
	/**
	 * Construct a Staff with blank information
	 */
	public Staff()
	{
		super();
		hourlyRate = 0.0;
	}
	
	/**
	 * Construct a Staff with given information (name, ID number, sex, birth date, and hourly rate)
	 * @param lastName last name
	 * @param firstName first name
	 * @param idNum ID number
	 * @param sex sex (M or F)
	 * @param birthDate birth date
	 * @param hourlyRate hourly rate
	 */
	public Staff(String lastName, String firstName, String idNum, char sex, Calendar birthDate, double hourlyRate)
	{
		super(lastName, firstName, idNum, sex, birthDate);
		this.hourlyRate = hourlyRate;
	}
	
	/**
	 * Get the Staff's hourly rate
	 * @return hourly rate
	 */
	public double getHourlyRate()
	{
		return hourlyRate;
	}
	
	/**
	 * Set the Staff's hourly rate
	 * @param hr hourly rate
	 */
	public void setHourlyRate(double hr)
	{
		hourlyRate = hr;
	}
	
	/**
	 * Set the Staff's monthly salary
	 * @return monthly salary
	 */
	public double monthlyEarning()
	{
		return hourlyRate * STAFF_MONTHLY_HOURS_WORKED;
	}
	
	public void inputEmployee(Scanner input)
	{
		super.inputEmployee(input);
		hourlyRate = input.nextDouble();
	}
	
	/**
	 * Print out the Staff's information (ID number, name, birth date, and monthly salary)
	 * @return the Staff's information
	 */
	public String toString()
	{
		return super.toString() + "\n" +
			   "\t" + "Full Time" + "\n" +
			   "\t" + "Monthly Salary: $" + Double.toString(monthlyEarning());
	}
	
	private double hourlyRate;
}
