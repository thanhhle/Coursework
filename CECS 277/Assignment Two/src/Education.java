import java.util.Scanner;

/**
 * Class Education
 * <p>
 * @author Thanh Le
 * @version 1.0
 * @Fall 2017
 */
public class Education implements Cloneable{

	/**
	 * Construct an education profile with blank information
	 */
	public Education()
	{
		degree = major = "";
		numResearch = 0;
	}
	
	/**
	 * Construct an education profile with given degree, major, and number of researches
	 * @param degree degree (MS or PhD)
	 * @param major major
	 * @param numResearch number of researches
	 */
	public Education(String degree, String major, int numResearch)
	{
		this.degree = degree;
		this.major = major;
		this.numResearch = numResearch;
	}
	
	/**
	 * Construct an education profile with the same content with the given education profile
	 * @param edu an education profile to be copied
	 */
	public Education(Education edu)
	{
		degree = edu.getDegree();
		major = edu.getMajor();
		numResearch = edu.getNumResearch();
	}
	
	/**
	 * Get the degree
	 * @return degree
	 */
	public String getDegree()
	{
		return degree;
	}
	
	/**
	 * Get the major
	 * @return major
	 */
	public String getMajor()
	{
		return major;
	}
	
	/**
	 * Get number of researches
	 * @return number of researches
	 */
	public int getNumResearch()
	{
		return numResearch;
	}
	
	/**
	 * Set the degree
	 * @param d degree
	 */
	public void setDegree(String d)
	{
		degree = d;
	}
	
	/**
	 * Set the major
	 * @param m major
	 */
	public void setMajor(String m)
	{
		major = m;
	}
	
	/**
	 * Set the number of researches
	 * @param nr number of researches
	 */
	public void setNumResearch(int nr)
	{
		numResearch = nr;
	}
	
	public Object clone() throws CloneNotSupportedException
	{  
		return super.clone();
	}
	
	private String degree;
	private String major;
	private int numResearch;
}
