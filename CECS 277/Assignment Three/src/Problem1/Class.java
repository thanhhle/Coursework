package Problem1;
/**
 * Describe a Class with name of subject and grade the student achieved
 */
public class Class {
	/**
	 * Construct a blank class's information
	 */
	public Class()
	{
		subject = "";
		grade = 0.0;
	}
	
	/**
	 * Construct a class's information with given name of subject and grade the student achieved
	 * @param subject name of the subject
	 * @param grade grade the student achieved
	 */
	public Class(String subject, double grade)
	{
		this.subject = subject;
		this.grade = grade;
	}
	
	/**
	 * Get the name of subject
	 * @return name of subject
	 */
	public String getSubject()
	{
		return subject;
	}
	
	/**
	 * Set the grade of student
	 * @return grade of student
	 */
	public double getGrade()
	{
		return grade;
	}
	
	/**
	 * Set the name of subject
	 * @param subject name of subject
	 */
	public void setSubject(String subject)
	{
		this.subject = subject;
	}
	
	/**
	 * Set the student's grade
	 * @param grade student's grade
	 */
	public void setGrade(double grade)
	{
		this.grade = grade;
	}
	
	/**
	 * Display class's information including name of subject and the grade student achieved
	 * @return class's information (name of subject and the grade student achieved)
	 */
	public String toString()
	{
		return subject + '\t' + '\t' + '\t' + grade + '\n';
	}
	
	private String subject;
	private double grade;
}
