package Problem3;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Class Partime extending from the class Staff
 * <p>
 * @author Thanh Le
 * @version 1.0
 * @Fall 2017
 */
public class Partime extends Staff{
	
	/**
	 * Construct a Part-time staff with blank information
	 */
	public Partime()
	{
		super();
		hoursWorkedPW = 0;
	}
	
	/**
	 * Construct a Part-time staff with given information (name, ID number, sex, birth date, hourly rate, and hours worked per week)
	 * @param lastName last name
	 * @param firstName first name
	 * @param idNum ID number
	 * @param sex sex (M or F)
	 * @param birthDate birth date
	 * @param hourlyRate hourly rate
	 * @param hoursWorkedPW hours worked per week
	 */
	public Partime(String lastName, String firstName, String idNum, char sex, Calendar birthDate, double hourlyRate, int hoursWorkedPW)
	{
		super(lastName, firstName, idNum, sex, birthDate, hourlyRate);
		this.hoursWorkedPW = hoursWorkedPW;
	}
	
	/**
	 * Get the Part-time staff's hours worked per week
	 * @return hours worked per week
	 */
	public int getHoursWorkedPW()
	{
		return hoursWorkedPW;
	}
	
	/**
	 * Set the Part-time staff's hours worked per week
	 * @param hours hours worked per week
	 */
	public void setHoursWorkedPW(int hours)
	{
		hoursWorkedPW = hours;
	}
	
	/**
	 * Get the Part-time staff's monthly salary
	 * @return monthly salary
	 */
	public double monthlyEarning()
	{
		return super.getHourlyRate() * hoursWorkedPW * 4; 
	}
	
	public void inputEmployee(Scanner input)
	{
		super.inputEmployee(input);
		hoursWorkedPW = input.nextInt();
	}
	
	/**
	 * Print out the Part-time staff's information (ID number, name, birth date, hours worked per month, and monthly salary)
	 * @return the Part-time staff's information
	 */
	public String toString()
	{
		return  "\t" + "ID Employee number: " + getIDNum() + "\n" +
				"\t" + "Employee name: " + getFirstName() + " " + getLastName() + "\n" + 
				"\t" + "Birth date: " + getBirthDate().get(Calendar.MONTH) + "/" + getBirthDate().get(Calendar.DAY_OF_MONTH) + "/" + getBirthDate().get(Calendar.YEAR) + "\n" +
				"\t" + "Hours works per month: " + hoursWorkedPW * 4 + "\n" +
				"\t" + "Monthly Salary: $" + Double.toString(monthlyEarning());
	}

	private int hoursWorkedPW;
}
