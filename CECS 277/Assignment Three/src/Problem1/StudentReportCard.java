package Problem1;
/**
 * Describe a StudentReportCard with student's information, list of classes along with grade, and average grade
 */
public class StudentReportCard {
	/**
	 * Construct a blank student report card
	 */
	public StudentReportCard()
	{
		student = new Student();
	}
	
	/**
	 * Construct a student report card with given student's information and his/her classes' information
	 * @param student student's information (name, age, and student ID)
	 * @param classes an array of classes' information (subjects and grades)
	 */
	public StudentReportCard(Student student, Class[] classes)
	{
		this.student = student;
		this.classes = classes;
	}
	
	/**
	 * Get the student's information
	 * @return student's information (name, age, and student ID)
	 */
	public Student getStudent()
	{
		return student;
	}
	
	/**
	 * Get the array of classes' information
	 * @return an array of classes' information (subjects and grades)
	 */
	public Class[] getClasses()
	{
		return classes;
	}
	
	/**
	 * Set the student's information
	 * @param student student's information
	 */
	public void setStudent(Student student)
	{
		this.student = student;
	}
	
	/**
	 * Set the array of class's information (subjects and grades) the student attends
	 * @param classes array of class's information (subjects and grades)
	 */
	public void setClasses(Class[] classes)
	{
		this.classes = classes;
	}
	
	/**
	 * Get the number of classes the student attends
	 * @return number of classes the student attends
	 */
	public int getNumClasses()
	{
		return classes.length;
	}
	
	/**
	 * Get the total grade of all classes the student attends
	 * @return the total grade of all classes the student attends
	 */
	public double getTotalGrade()
	{
		double totalGrade = 0.0;
		for(Class c: classes)
		{
			totalGrade = totalGrade + c.getGrade();
		}
		
		return totalGrade;
	}
	
	/**
	 * Get the average grade of the student
	 * @return average grade of the student
	 */
	public double getAverageGrade()
	{
		return getTotalGrade()/getNumClasses();
	}
	
	/**
	 * Display the student report card
	 * @return the student report card
	 */
	public String toString()
	{
		String display = student.toString() + '\n';
		display = display + "-------------------------------------" + "\n";
		
		for(Class c: classes)
		{
			display = display + c.toString();
		}
		display = display + "-------------------------------------" + "\n";
		
		display = display + "\t" + "\t" + " Average Grade: " + getAverageGrade() + "\n";
		return display;
	}

	private Student student;
	private Class[] classes;
}
