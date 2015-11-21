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
    }

   
}


