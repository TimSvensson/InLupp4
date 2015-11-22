import org.junit.*;
import junit.framework.TestCase;

/**
 * A JUnit test case class
 */
public class RegisterTest extends TestCase
{

    private Customer customer1;
    private Customer customer2;

    @Before
    protected void setUp()
    {
    }
    
    @Test
    public void test_open() {
	Register kassa = new Register();
	kassa.open();
	boolean open = kassa.isOpen();
	assertTrue(open == true);
    }

    @Test
    public void test_close() {
	Register reg = new Register();
	reg.open();
	reg.close();
	boolean closed = reg.isOpen();
	assertTrue(closed == false);
    }

    @Test
    public void test_step() {
	
    }

    @Test
    public void test_hasCustomers() {
	Register reg = new Register();
	Customer Frida = new Customer(0, 5);
        reg.addToQueue(Frida);
	boolean b = reg.hasCustomers();
	assertTrue(b == true);

	Register reg1 = new Register();
	boolean a = reg1.hasCustomers();
	assertTrue(a == false);
	
    }

    @Test
    public void test_currentCustomerIsDone() {
	Register reg = new Register();
	Customer Knas = new Customer(0, 1);
	reg.addToQueue(Knas);
	reg.step();
	boolean c = reg.currentCustomerIsDone();
	assertTrue(c == true);
    }
}
