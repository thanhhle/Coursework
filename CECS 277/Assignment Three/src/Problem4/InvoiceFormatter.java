package Problem4;

/**
	Formats the invoice
 */
public class InvoiceFormatter {
	private Invoice invoice;
	private Address address;
	
	/**
	 * Constructs an invoice formatter from the invoice
	 * @param i invoice
	 */
	public InvoiceFormatter(Invoice i)
	{
		invoice = i;
		address = i.getAddress();
	}
	
	public String format()
	{
		String output = "                    I N V O I C E\n\n"
	            + formatAddress()
	            + String.format("\n\n%-30s%8s%5s%8s\n",
	               "Description", "Price", "Qty", "Total");
		
		for (LineItem item : invoice.getItems())
	    {  
	         output = output + formatLineItem(item) + "\n";
	    }
		
		output = output + String.format("\nAMOUNT DUE: $%8.2f", invoice.getAmountDue());
		
		return output;
	}
	
	private String formatAddress()
	{
		 return address.getName() + "\n" + address.getStreet() + "\n"
		            + address.getCity() + ", " + address.getState() + " " + address.getZip();
	}
	
	private String formatLineItem(LineItem item)
	{
		return String.format("%-30s%8.2f%5d%8.2f", 
		         item.getTheProduct().getDescription(), item.getTheProduct().getPrice(), 
		         item.getQuantity(), item.getTotalPrice());
	}
}
