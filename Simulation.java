import java.util.Random;

public class Simulation {
    Store store;

    int time;
    int intensity;
    int maxGroceries;
    int thresholdForNewRegister;

    Random random = new Random();

    public Simulation(int numberOfRegisters, int thresholdForNewRegister, int intensity) {
	this.store = new Store(numberOfRegisters, thresholdForNewRegister);
    }

    public void step() {
	this.time += 1;
	this.store.step();

	if(newCustomer()) {
	    Customer c = createNewCustomer();
	    AddCustomerToStore(c);
	}
	int averageRegisterLength = getAverageRegisterLength();

	//hämta alla kunder och för statestik
    }

    private int getAverageRegisterLength() {
	return this.store.getAverageQueueLength();
    }

    private void AddCustomerToStore(Customer c) {
	this.store.newCustomer(c);
    }

    private boolean newCustomer() {
	int number = random.nextInt(100);
	return number < intensity;
    }

    private Customer createNewCustomer() {
	int grocerise = random.nextInt(this.maxGroceries);
	Customer c = new Customer(this.time, grocerise);
	return c;
    }

    public String toString() {
	return "Stuff";
    }
}
