import org.junit.*;
import junit.framework.TestCase;

/**
 * A JUnit test case class
 */
public class CustomerTest extends TestCase
{

    private Customer customer1;
    private Customer customer2;

    @Before
    protected void setUp()
    {
    }

    @Test
    public void test_serve() {
	Customer Pelle = new Customer(0, 10);
	assertTrue(Pelle.getGroceries() == 10);
	Pelle.serve();
	assertTrue(Pelle.getGroceries() == 9);

	Customer Calle = new Customer (0, 0);
	assertTrue(Calle.getGroceries() == 0);
	Pelle.serve();
	assertTrue(Calle.getGroceries() == 0);
    }


    @Test
    public void test_isDone() {
	Customer Pellina = new Customer(0, 4);
	boolean result = Pellina.isDone();
	assertTrue(result == false);
        Customer Callina = new Customer(0, 0);
	boolean result2 = Callina.isDone();
	    assertTrue(result2 == true);
    }

    @Test
    public void test_getGroceries() {
	Customer Frej = new Customer(0, 7);
	assertTrue(Frej.getGroceries() == 7);
	Customer Freja = new Customer(0, 0);
	assertTrue(Freja.getGroceries() == 0);
	
    }


    @Test
    public void test_getBornTime() {
	Customer Sunshine = new Customer(0, 5);
	assertTrue(Sunshine.getBornTime() == 0);
	Customer Starshine = new Customer(4, 912);
	assertTrue(Starshine.getBornTime() == 4);
    }

    
}



