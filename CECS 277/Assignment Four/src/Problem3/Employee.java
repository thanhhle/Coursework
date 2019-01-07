package Problem3;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Abstract class Employee
 * <p>
 * @author Thanh Le
 * @version 1.0
 * @Fall 2017
 */

abstract class Employee implements EmployeeInfo, Comparable, Cloneable {
	
	/**
	 * Construct an Employee with default argument
	 */
	public Employee()
	{
		lastName = firstName = idNum = "";
		sex = '\u0000';
		birthDate = new GregorianCalendar();
	}
	
	/**
	 * Construct an Employee with given argument
	 * @param lastName last name
	 * @param firstName first name
	 * @param idNum ID number
	 * @param sex sex (M or F)
	 * @param birthDate birth date
	 */
	public Employee(String lastName, String firstName, String idNum, char sex, Calendar birthDate)
	{
		this.lastName = lastName;
		this.firstName = firstName;
		this.idNum = idNum;
		this.sex = sex;
		this.birthDate = birthDate;
	}
	
	/**
	 * Get the Employee's last name
	 * @return last name
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * Get the Employee's first name
	 * @return first name
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * Get the Employee's ID number
	 * @return ID number
	 */
	public String getIDNum()
	{
		return idNum;
	}
	
	/**
	 * Get the Employee's sex
	 * @return sex (M or F)
	 */
	public char getSex()
	{
		return sex;
	}
	
	/**
	 * Get the Employee's birth date
	 * @return birth date
	 */
	public Calendar getBirthDate()
	{
		return birthDate;
	}
	
	/**
	 * Set the Employee's last name
	 * @param ln last name
	 */
	public void setLastName(String ln)
	{
		lastName = ln;
	}
	
	/**
	 * Set the Employee's first name
	 * @param fn first name
	 */
	public void setFirstName(String fn)
	{
		firstName = fn;
	}
	
	/**
	 * Set the Employee's ID number
	 * @param id ID number
	 */
	public void setIDNum(String id)
	{
		idNum = id;
	}
	
	/**
	 * Set the Employee's sex
	 * @param s sex (M or F)
	 */
	public void setSex(char s)
	{
		sex = s;
	}
	
	/**
	 * Set the Employee's birth date
	 * @param bd birth date
	 */
	public void setBirthDate(Calendar bd)
	{
		birthDate = bd;
	}
	
	/**
	 * Print out the Employee's information (ID number, name, and birth date)
	 * @return the Employee's information
	 */
	public String toString()
	{
		return 	"\t" + "ID Employee number: " + idNum + "\n" +
				"\t" + "Employee name: " + firstName + " " + lastName + "\n" + 
				"\t" + "Birth date: " + birthDate.get(Calendar.MONTH) + "/" + birthDate.get(Calendar.DAY_OF_MONTH) + "/" + birthDate.get(Calendar.YEAR);
	}
	
	public int compareTo(Object otherEmployee)
	{
		return -idNum.compareTo(((Employee)otherEmployee).idNum);
	}
	
	public Object clone() throws CloneNotSupportedException
	{  
		return super.clone();
	}
	
	/**
	 * Get the Employee's monthly salary
	 * @return monthly salary
	 */
	abstract public double monthlyEarning();
	
	/**
	 * Input information for the employee
	 * @param input the scanner that scans the employee's information file
	 */
	public void inputEmployee(Scanner input)
	{
		lastName = input.next();
		firstName = input.next();
		idNum = input.next();
		sex = input.next().toUpperCase().charAt(0);
		String bDay = input.next();
		birthDate = new GregorianCalendar(Integer.parseInt(bDay.substring(bDay.lastIndexOf("/")+1)), Integer.parseInt(bDay.substring(0, bDay.indexOf("/"))), Integer.parseInt(bDay.substring(bDay.indexOf("/")+1, bDay.lastIndexOf("/"))));
	}
	
	private String lastName;
	private String firstName;
	private String idNum;
	private char sex;
	private Calendar birthDate;
}
