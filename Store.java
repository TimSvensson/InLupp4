import java.util.ArrayList;


/**
 * This class provides methodes for the Store
 */
public class Store {
    ArrayList<Register> registers;
   
    int numberOfRegisters;
    int thresholdForNewRegister;

    /**
     * Creates all the registers in the store
     */
    public Store(int numberOfRegisters, int thresholdForNewRegister) {
	this.numberOfRegisters = numberOfRegisters;
	this.thresholdForNewRegister = thresholdForNewRegister;
	this.registers = new ArrayList<Register>();

	for(int i = 0; i < numberOfRegisters; i++) {
	    this.registers.add(new Register());
	}
    }

    /**
     * Finds out how many registers are open
     */
    private int getOpenRegisters() {
	int openRegisters = 0;
	for (Register r : this.registers) {
	    if (r.isOpen()) { openRegisters++; }
	}
	return openRegisters;
    }

    /**
     * Finds the average queue length
     */
    public int getAverageRegisterLength() {
	int lengthOfAllQueues = 0;
	for(Register r : registers) {
	    lengthOfAllQueues += r.getQueueLength();
	}
	return lengthOfAllQueues / getOpenRegisters();
    }

    /**
     * Inserts a customer in the shortest queue
     *
     * @param the customer c to insert
     */
    public void newCustomer(Customer c) {
	Register r = this.getShortestRegister();
	r.addToQueue(c);
    }

    /**
     * Finds the shortest queue 
     */
    private Register getShortestRegister() {
	Register shortest = this.registers.get(0);
	for(Register r : this.registers) {
	    if(r.isOpen()) {
		if(r.getQueueLength() < shortest.getQueueLength()) {
		    shortest = r;
		}
	    }
	}
	return shortest;
    }

    /**
     * Steps the time counter in the store by one
     */
    public void step() {
	for(Register r : registers) {
	    r.step();
	}
	if (checkOpenNewRegister()) {
	    openNewRegister();
	}
    }

    /**
     * Checks if a new register needs to be opened
     */
    public boolean checkOpenNewRegister() {
	if (getOpenRegisters() == 0) {
	    return true;
	} else {
	return getAverageRegisterLength() > this.thresholdForNewRegister;
	}
    }

    /**
     * Opens a new register
     */
    public void openNewRegister() {
	for(Register r : registers) {
	    if(!r.isOpen()) {
		r.open();
		break;
	    }
	}
    }

    /**
     * Returns all done customers in the current time step
     */
    public ArrayList<Customer> getDoneCustomers() {
	ArrayList<Customer> doneCustomers = new ArrayList<Customer>();
	for(Register r : registers) {
	    if(r.isOpen()) {
		if(r.hasCustomers()) {
		    if(r.currentCustomerIsDone()) {
			doneCustomers.add(r.removeCurrentCustomer());
		    }
		}
	    }
	}
	return doneCustomers;
    }

    public String toString() {
	String s = "";
	for(Register r : registers) {
	    s += r.toString() + "\n";
	}
	return s;
    }


    
    //ONLY FOR TESTING
    public int getResultgetOpenRegisters() {
	int amount = getOpenRegisters();
	return amount;
    }

}
