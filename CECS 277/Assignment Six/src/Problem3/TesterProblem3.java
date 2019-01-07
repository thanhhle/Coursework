package Problem3;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TesterProblem3 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		Map<Integer, Student> StudentMap = new HashMap<Integer, Student>();
		Map<Student, String> GradeMap = new HashMap<Student, String>();
		
		//Run these codes once to generate StudentMap and GradeMap and save them to StudentMap.dat and GradeMap.dat
		/*
		generateMaps(GradeMap, StudentMap);
			
		ObjectOutputStream GradeMapOutput = new ObjectOutputStream(new FileOutputStream("GradeMap.dat"));
		ObjectOutputStream StudentMapOutput = new ObjectOutputStream(new FileOutputStream("StudentMap.dat"));
		GradeMapOutput.writeObject(GradeMap);
		StudentMapOutput.writeObject(StudentMap);
		GradeMapOutput.close();
		StudentMapOutput.close();
		*/

		ObjectInputStream GradeMapInput = new ObjectInputStream(new FileInputStream("GradeMap.dat"));
		ObjectInputStream StudentMapInput = new ObjectInputStream(new FileInputStream("StudentMap.dat"));
		StudentMap = (Map<Integer, Student>)StudentMapInput.readObject();
		GradeMap = (Map<Student, String>)GradeMapInput.readObject();
		GradeMapInput.close();
		StudentMapInput.close();
		
		printMenuAndGetChoice(GradeMap, StudentMap);
		
		ObjectOutputStream GradeMapOutput = new ObjectOutputStream(new FileOutputStream("GradeMap.dat"));
		ObjectOutputStream StudentMapOutput = new ObjectOutputStream(new FileOutputStream("StudentMap.dat"));
		GradeMapOutput.writeObject(GradeMap);
		StudentMapOutput.writeObject(StudentMap);
		GradeMapOutput.close();
		StudentMapOutput.close();
	}

	public static void generateMaps(Map<Student, String> GradeMap, Map<Integer, Student> StudentMap) throws FileNotFoundException
	{
		String gradeList[] = {"A", "B", "C", "D", "F"};
		Scanner input = new Scanner(new FileReader("inputStudents.txt"));
		while(input.hasNext())
		{
			Student s = new Student();
			s.inputStudent(input);
			StudentMap.put(s.getID(), s);
			GradeMap.put(s, gradeList[(int)(Math.random()*gradeList.length)]);
		}
	}
	
	public static void printMenuAndGetChoice(Map<Student, String> GradeMap, Map<Integer, Student> StudentMap)
	{
		while(true)
		{
			System.out.println("1) Add a student");
			System.out.println("2) Remove a student");
			System.out.println("3) Modify a student's grade");
			System.out.println("4) Print the students and grades");
			System.out.println("5) Quit");
		
			Scanner input = new Scanner(System.in);
			int choice = input.nextInt();
			if(choice == 1)				addStudent(GradeMap, StudentMap);
			else if(choice == 2)		removeStudent(GradeMap, StudentMap);
			else if(choice == 3)		modifyStudentGrade(GradeMap, StudentMap);
			else if(choice == 4)		print(GradeMap);
			else if(choice == 5)		break;
			else						System.out.println("Invalid choice. Re-enter your choice!");
			
			System.out.println();
		}
	}
	
	/**
	 * Adds a student based on user input.  Prints an error if a student is added that already exists in the map.
	 * @param GradeMap the map to associate student object with a grade
	 * @param StudentMap the map to associate student id with an student.
	 * @throws FileNotFoundException 
	 */
	public static void addStudent(Map<Student, String> GradeMap, Map<Integer, Student> StudentMap)
	{
		Scanner input = new Scanner(System.in);
		Student s = new Student();
		System.out.println("Enter the student's information (first name, last name, and ID)");
		s.inputStudent(input);
		System.out.println("Enter the student's grade");
		String grade = input.next();
		if(StudentMap.containsKey(s.getID()))
		{
			System.out.println("Student already existed");
		}
		else
		{
			StudentMap.put(s.getID(), s);
			GradeMap.put(s, grade);
		}
	}
	
	/**
	 * Removes a student from the map based on user input
	 * @param GradeMap the map to associate student object with a grade.
	 * @param StudentMap the map to associate student id with an student. 
	 */
	public static void removeStudent(Map<Student, String> GradeMap, Map<Integer, Student> StudentMap)
	{
		System.out.println("Enter the ID of student to be removed");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		Student s = StudentMap.get(id);
		StudentMap.remove(id);
		GradeMap.remove(s);
	}
	
	/**
	 * Modifies an entry based on user input. Prints an error if an invalid student is modified.
	 * @param GradeMap the map to associate student object with a grade.
	 * @param StudentMap the map to associate student id with an student
	 */
	public static void modifyStudentGrade(Map<Student, String> GradeMap, Map<Integer, Student> StudentMap)
	{
		System.out.println("Enter the ID of student to be modified");
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		if(StudentMap.containsKey(id))
		{
			Student s = StudentMap.get(id);
			System.out.println("Enter student's new grade");
			String grade = input.next().toUpperCase();
			GradeMap.replace(s, grade);
		}
		else
		{
			System.out.println("That student doesn't not exist to be modified");
		}
	}
	
	/**
	 * Prints the students and grades
	 * @param GradeMap the map to print
	 */ 
	public static void print(Map<Student, String> GradeMap)
	{
		System.out.println("Name\t\t\tID\t\tGrade");
		System.out.println("-----------------------------------------------");
		List<Map.Entry<Student, String>> list = new ArrayList<Map.Entry<Student, String>>(GradeMap.entrySet());
		Collections.sort(list, new StudentComparator());
		for(Map.Entry<Student, String> entry: list)
		{
			String name = entry.getKey().getFirstName() + " " + entry.getKey().getLastName();
			int id = entry.getKey().getID();
			String grade = entry.getValue();
			System.out.println(name + "\t\t" + id + "\t\t" + grade);
		}
	}
}