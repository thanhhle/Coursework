import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DebitTest {
	private BankAccount ba;

	@Before
	public void setUp() throws Exception 
	{
		System.out.println("Run @Before"); // for illustration
		ba = new BankAccount("Mr. Bryan Walton", 3.5);	
	}
 
	@After
	public void tearDown() throws Exception 
	{
		System.out.println("Run @After"); // for illustration
	}

	@Test
	public void testSetDebitPass() throws Exception
	{
		System.out.println("Run @TestSetDebitPass");
		double currentBalance = ba.getBalance();
		double debit = 2.0;
		ba.setDebit(debit);
		assertEquals("error in setDebit()", currentBalance - debit, ba.getBalance(), 0.01);
	}
	
	@Test
	public void testSetDebitFail() throws Exception
	{
		System.out.println("Run @TestSetDebitFail");
		double currentBalance = ba.getBalance();
		double debit = 2.0;
		ba.setDebit(debit);
		assertNotEquals("error in setDebit()", currentBalance + debit, ba.getBalance(), 0.01);
	}
}
