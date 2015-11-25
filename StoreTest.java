import org.junit.*;
import junit.framework.TestCase;
import java.util.ArrayList;

/**
 * A JUnit test case class
 */
public class StoreTest extends TestCase
{

    private Customer customer1;
    private Customer customer2;

    @Before
    protected void setUp()
    {
    }

    @Test
    public void test_getAverageRegisterLength() {
	Store ica = new Store(2, 5);
        ica.openNewRegister();
	ica.openNewRegister();
	ica.newCustomer(new Customer(1,9));
	ica.newCustomer(new Customer(4, 6));
	ica.newCustomer(new Customer(0, 5));
	int len = ica.getAverageRegisterLength();
	Assert.assertEquals(1, len);
    }

    @Test
    public void test_newCustomerAndgetDoneCustomers() {
	Store coop = new Store(10, 5);
	Customer kurt = new Customer(0, 0);
	coop.newCustomer(kurt);
	ArrayList<Customer> kunder = coop.getDoneCustomers();
	boolean contains = kunder.contains(kurt);
	assert(contains == true);
	   
    }

    /*    @Test
    public void test_getShortestRegister() {
	Store willys = new Store(6, 4);
	willys.openNewRegister();
	willys.newCustomer(new Customer(4, 6));
	Register reg1 = willys.getShortestRegister();
	int length = reg1.getQueueLength();
	assert(length == 1);
	willys.openNewRegister();
        willys.newCustomer(new Customer(8, 4));
	willys.newCustomer(new Customer(5, 9));
	Register reg2 = willys.getShortestRegister();
	int len = reg2.getQueueLength();
	assert(len == 2);

	} */


    @Test
    public void test_step() {
	Store hemkop = new Store(3, 9);
	Customer Kaj = new Customer(0, 1);
	Customer Kaj2 = new Customer(1, 0);
	hemkop.newCustomer(Kaj);
	hemkop.step();
	ArrayList<Customer> kunder = hemkop.getDoneCustomers();
	boolean contains = kunder.contains(Kaj2);
	assert(contains == true);
    }


       @Test
    public void test_checkOpenNewRegisterAndNewRegister() {
	   Store hm = new Store(2, 2);
	   hm.newCustomer(new Customer(2, 4));
	   hm.newCustomer(new Customer(1, 5));
	   hm.newCustomer(new Customer(0, 7));
	   hm.openNewRegister();
	   int kassor = hm.getResultgetOpenRegisters();
	   assert(kassor == 1);
	   boolean open = hm.checkOpenNewRegister();
	   assert(open == true);
    }

}
