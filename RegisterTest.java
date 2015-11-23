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
	Register reg = new Register();
	Customer Findus = new Customer(3, 5);
	reg.addToQueue(Findus);
	reg.step();
	int groceries1 = Findus.getGroceries();
	assertTrue(groceries1 == 4);
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

	/* KOLLA OM CUSTOMER ÄR KLAR NÄR DEN INTE ÄR DET
	Register kassa = new Register();
	Customer Bamse = new Customer(0,2);
	reg.addToQueue(Bamse);
	reg.step();
	try {
	    reg.currentCustomerIsDone();
	} 

	#FAIL!!!
	catch (NullPointerException e) {
	    boolean fail = false;
	    return fail;
	    
	}
	assertTrue(fail == false); 
	*/
	

    } 


    @Test
    public void test_addToQueueremoveCurrentCustomer() {
	Register reg = new Register();
	Customer Lilleskutt = new Customer(0, 7);
	reg.addToQueue(Lilleskutt);
	Customer last = reg.removeCurrentCustomer();
	assertTrue(Lilleskutt == last);

	/* NULLPOINTEREXCEPTIONS!*/

	/*	Register kassa = new Register();
	if (kassa.removeCurrentCustomer == null)
	    {
		boolean fail = false;
		return fail;
	    }
	assertTrue(fail == false);
	*/
    }
    
    @Test
    public void test_getQueueLength() {
	Register reg = new Register();
	int len = reg.getQueueLength();
	assertTrue(len == 0);

	Register kassa = new Register();
	Customer KjellKantarell = new Customer(3, 7);
	kassa.addToQueue(KjellKantarell);
	int length = kassa.getQueueLength();
	assertTrue(length == 1);

	Register register = new Register();
	Customer Tom = new Customer(2, 8);
	Customer Jerry = new Customer(9, 5);
	register.addToQueue(Tom);
	register.addToQueue(Jerry);
	int leng = register.getQueueLength();
	assertTrue(leng == 2);
    }



    
}
