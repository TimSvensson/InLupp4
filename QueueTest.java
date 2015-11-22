import org.junit.*;
import junit.framework.TestCase;

/**
 * A JUnit test case class
 */
public class QueueTest extends TestCase
{

    private Customer customer1;
    private Customer customer2;

    @Before
    protected void setUp()
    {
    }

    @Test
    public void test_lengthEnqueue() {
	Queue<Customer> testqueue1 = new Queue<Customer>();
	Customer Greta = new Customer(0, 5);
	testqueue1.enqueue(Greta);
	int len = testqueue1.length();
	assertTrue(len == 1);

	Queue<Customer> testqueue2 = new Queue<Customer>();
	int leng = testqueue2.length();
	assertTrue(leng == 0);

	Queue<Customer> testqueue3 = new Queue<Customer>();
	Customer Kajsa = new Customer(0, 3);
	Customer Kaj = new Customer(4, 7);
	testqueue3.enqueue(Kajsa);
	testqueue3.enqueue(Kaj);
	int lengthQ = testqueue3.length();
	assertTrue(lengthQ == 2);

    }

    @Test
    public void test_dequeue() {
	Queue<Customer> testqueue4 = new Queue<Customer>();
	Customer Pinne = new Customer(0, 4);
	Customer Gren = new Customer(0,1);
	testqueue4.enqueue(Pinne);
	testqueue4.enqueue(Gren);
	Customer firstCustomer = testqueue4.first();
	testqueue4.dequeue();
	Customer firstCustomer2 = testqueue4.first();
	assertTrue(firstCustomer != firstCustomer2);
    }

    @Test
    public void test_first() {
	Queue<Customer> Aqueue = new Queue<Customer>();
	Customer Leffe = new Customer(4, 19);
	Aqueue.enqueue(Leffe);
	Customer firstCust = Aqueue.first();
	assertTrue(Leffe == firstCust);
    }
    
}
