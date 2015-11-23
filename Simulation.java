import java.util.Random;
import java.util.ArrayList;

/**
 * This class contains methods for simulating the actions in the store
 */

public class Simulation {
    Store store;

    int time;
    int intensity;
    int maxGroceries;
    int thresholdForNewRegister;

    Random random = new Random();
    Meta meta = new Meta();

    private class Meta {
	int customersServed;
	int maxWaitTime;
	float averageWaitTime;
	int totalWaitTime;

	private Meta() {
	    this.customersServed = 0;
	    this.maxWaitTime = 0;
	    this.averageWaitTime = 0;
	    this.totalWaitTime = 0;
	}

	public void step(ArrayList<Customer> doneCustomers, int time) {
	    this.customersServed += doneCustomers.size();
	    for (Customer c : doneCustomers) {
		int timeWaiting = time - c.getBornTime();
		this.totalWaitTime += timeWaiting;
		if (timeWaiting > maxWaitTime) {
		    maxWaitTime = timeWaiting;
		}
	    }
	    try {
		this.averageWaitTime = (float)this.totalWaitTime / (float)this.customersServed;
	    } catch (ArithmeticException e) {
		this.averageWaitTime = 0;
	    }
	}

	public String toString() {
	    String s = "";
	    s += "Number of customers served: " + this.customersServed + "\n";
	    s += "Max wait-time: " + this.maxWaitTime + "\n";
	    s += "Average wait-time: " + this.averageWaitTime + "\n";
	    return s;
	}
    }

    public Simulation(int numberOfRegisters, int thresholdForNewRegister, int intensity, int maxGroceries) {
	this.store = new Store(numberOfRegisters, thresholdForNewRegister);
	this.intensity = intensity;
	this.maxGroceries = maxGroceries;
    }

    /**
     * Steps the time counter with one
     */
    public void step() {
	this.time += 1;
	this.store.step();
	if(customerArrives()) {
	    Customer c = createNewCustomer();
	    AddCustomerToStore(c);
	}
	this.meta.step(this.store.getDoneCustomers(), this.time);
    }

    /**
     * Finds the average queue length
     */
    private int getAverageQueueLength() {
	return this.store.getAverageRegisterLength();
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
    private boolean customerArrives() {
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
	String s = "Store\n\n";
	s += this.store.toString();
	s += "\n\n" + this.meta.toString() + "\n";
	return s;
    }
}
