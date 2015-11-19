import java.util.Random;
import java.util.ArrayList;

public class Simulation {
    Store store;

    int time;
    int intensity;
    int maxGroceries;
    int thresholdForNewRegister;

    ArrayList<Customer> doneCustomers = new ArrayList<Customer>();

    Random random = new Random();

    public Simulation(int numberOfRegisters, int thresholdForNewRegister, int intensity) {
	this.store = new Store(numberOfRegisters, thresholdForNewRegister);
    }

    
    /**
     * Steps the time counter with one
     */
    
    public void step() {
	this.time += 1;
	this.store.step();

	if(newCustomer()) {
	    Customer c = createNewCustomer();
	    AddCustomerToStore(c);
	}
	int averageRegisterLength = getAverageQueueLength();

	this.doneCustomers.addAll(this.store.getDoneCustomers());
    }


    /**
     * Finds the average queue length
     */
    
    private int getAverageQueueLength() {
	return this.store.getAverageQueueLength();
    }

    
    /**
     * Adds a customer to the store
     *
     * @param the added customer c
     */

    private void AddCustomerToStore(Customer c) {
	this.store.newCustomer(c);
    }

    
    /**
     * Checks wheter a new customer is wanted or not
     */

    private boolean newCustomer() {
	int number = random.nextInt(100);
	return number < intensity;
    }


    /**
     * Creates a new customer
     */

    private Customer createNewCustomer() {
	int grocerise = random.nextInt(this.maxGroceries);
	Customer c = new Customer(this.time, grocerise);
	return c;
    }

    public String toString() {
	return this.store.toString();
    }
}
