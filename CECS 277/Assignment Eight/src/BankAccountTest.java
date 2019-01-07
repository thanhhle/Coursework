import java.util.*;
public class BankAccountTest {

	public static void main(String[] args) throws Exception
	{
		BankAccount ba = new BankAccount("Mr. Bryan Walton", 3.5);
		ba.setCredit(1.00); 
		ba.setDebit(2.0); 
		System.out.println("Current balance is " + ba.getBalance());
	}
}
