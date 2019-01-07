package Problem1;
/**
 * Describe a Student with name, grade level, and ID number
 */
public class Student {
	/**
	 * Construct a blank student's information
	 */
	public Student()
	{
		name = IDNum = "";
		gradeLevel = 0;
	}
	
	/**
	 * Construct a student's information with name, age, and student ID
	 * @param name name
	 * @param gradeLevel grade level
	 * @param IDNum student ID
	 */
	public Student(String name, int gradeLevel, String IDNum)
	{
		this.name = name;
		this.gradeLevel = gradeLevel;
		this.IDNum = IDNum;
	}
	
	/**
	 * Get the student's name
	 * @return the student's name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Get the student's grade level
	 * @return the student's grade level
	 */
	public int getGradeLevel()
	{
		return gradeLevel;
	}
	
	/**
	 * Get the student's ID number
	 * @return student ID number
	 */
	public String getIDNum()
	{
		return IDNum;
	}
	
	/**
	 * Set the student's name
	 * @param name name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Set the student's grade level
	 * @param gradeLevel grade level
	 */
	public void setGradeLevel(int gradeLevel)
	{
		this.gradeLevel = gradeLevel;
	}
	
	/**
	 * Set the studnet's ID number
	 * @param IDNum ID number
	 */
	public void setIDNum(String IDNum)
	{
		this.IDNum = IDNum;
	}
	
	/**
	 * Display student's information with name, age, and student ID
	 * @return student's information (name, age, and student ID)
	 */
	public String toString()
	{
		return "Name: " + name + "\n" + "Grade Level: " + gradeLevel + '\n' + "ID Number: " + IDNum;
	}
	
	private String name;
	private int gradeLevel;
	private String IDNum;
}
