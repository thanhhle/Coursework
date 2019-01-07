//Thanh Le, 015809792, CashRegister
/**
 * 
 * @author Thanh Le
 * 
 * A simulated cash register that totals up sales and compute change due
 *
 */
public class CashRegister {
	
	/**
	 * Construct a simulated cash register
	 */
	public CashRegister()
	{
		purchase = payment = 0.0;
	}
	
	/**
	 * Record the purchase price of the product
	 * @param amount the purchase price of the product
	 */
	public void recordPurchase(double amount)
	{
		purchase = amount;
	}

	/**
	 * Record the payment
	 * @param unitCount	unit of money
	 * @param monetaryUnitType type of monetary unit
	 */
	public void enterPayment(int unitCount, MonetaryUnit monetaryUnitType)
	{
		payment = payment + unitCount * monetaryUnitType.getValue();
	}

	/**
	 * Compute and return the change
	 * @return the change
	 */
	public double giveChange()
	{
		return payment - purchase;
	}
	
	private double purchase;
	private double payment;
}
