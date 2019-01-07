//Thanh Le, 015809792, MonetaryUnit
/**
 * 
 * @author Thanh Le
 * 
 * A Monetary Unit class to return the name of the monetary unit and the monetary value of the unit
 *
 */
public class MonetaryUnit {

	/**
	 * Construct a monetary unit with given value and name
	 * @param value the monetary value of the unit
	 * @param name the name of the monetary unit
	 */
	public MonetaryUnit(double value, String name)
	{
		this.value = value;
		this.name = name;
	}
	
	/**
	 * Return the value of the monetary unit
	 * @return the value of the monetary unit
	 */
	public double getValue()
	{
		return value;
	}
	
	/**
	 * Return the name of the monetary unit
	 * @return the name of the monetary unit
	 */
	public String getName()
	{
		return name;
	}
	
	
	private double value;
	private String name;
}
