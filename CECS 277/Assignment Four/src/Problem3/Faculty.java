package Problem3;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Class Faculty extending from the class Employee
 * <p>
 * @author Thanh Le
 * @version 1.0
 * @Fall 2017
 */
public class Faculty extends Employee implements Cloneable{
	
	/**
	 * Construct a Faculty with blank information
	 */
	public Faculty()
	{
		super();
		education = new Education();
	}
	
	/**
	 * Construct a Faculty with given information of name, ID number, sex, birth date, level, and education
	 * @param lastName last name
	 * @param firstName first name
	 * @param idNum ID number
	 * @param sex sex (M or F)
	 * @param birthDate birth date
	 * @param level level
	 * @param education education
	 */
	public Faculty(String lastName, String firstName, String idNum, char sex, Calendar birthDate, Level level, Education education)
	{
		super(lastName, firstName, idNum, sex, birthDate);
		this.level = level;
		this.education = new Education(education);
	}
	
	/**
	 * Get the Faculty's level
	 * @return level
	 */
	public Level getLevel()
	{
		return level;
	}
	
	/**
	 * Get the Faculty's education
	 * @return education
	 */
	public Education getEducation()
	{
		return education;
	}
	
	/**
	 * Set the Faculty's level
	 * @param l level
	 */
	public void setLevel(Level l)
	{
		level = l;
	}
	
	/**
	 * Set the Faculty's education
	 * @param edu education
	 */
	public void setEducation(Education edu)
	{
		education = edu;
	}
	
	/**
	 * Get the monthly salary based on the Faculty's level
	 * @return monthly salary
	 */
	public double monthlyEarning()
	{
		switch(level)
		{
			case AS:	return FACULTY_MONTHLY_SALARY;
			case AO:	return 1.5 * FACULTY_MONTHLY_SALARY;
			case FU:	return 2.0 * FACULTY_MONTHLY_SALARY;
		}
		return 0.0;
	}
	
	public void inputEmployee(Scanner input)
	{
		super.inputEmployee(input);
		level = Level.valueOf(input.next().toUpperCase());
		education.inputEducation(input);
	}
	
	/**
	 * Print out the Faculty's information (ID number, name, birth date, level, and monthly salary)
	 * @return the Faculty's information
	 */
	public String toString()
	{
		return super.toString() + 
			   "\n" + "\t" + level.getStrLevel() + 
			   "\n" + "\t" + "Monthly Salary: $" + Double.toString(monthlyEarning());
	}
	
	
	public Object clone() throws CloneNotSupportedException
	{  
		Faculty copyFaculty = (Faculty) super.clone();
		education = (Education) education.clone();
		copyFaculty.setEducation(education);
		return copyFaculty;
	}
	
	
	public enum Level
	{
		AS("Assistant Professor"), AO("Associate Professor"), FU("Full Professor");
		
		private String typeProfessor;
		
		private Level(String str)
		{
			typeProfessor = str;
		}
		
		private String getStrLevel()
		{
			return typeProfessor;
		}
	}
	
	private Level level;
	private Education education;
}
