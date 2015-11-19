import java.util.ArrayList;

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

	this.registers.get(0).open();
    }


    /**
     * Finds the average queue length
     */
    
    public int getAverageQueueLength() {
	int lengthOfAllQueues = 0;
	for(Register r : registers) {
	    lengthOfAllQueues += r.getQueueLength();
	}
	return lengthOfAllQueues / this.numberOfRegisters;
    }


    /**
     * Inserts a customer in the shortest queue
     *
     * @param the customer c to insert
     */
    
    public void newCustomer(Customer c) {
	Register r = this.getShortestQueue();
	r.addToQueue(c);
    }


    /**
     * Finds the shortest queue 
     */

    private Register getShortestQueue() {
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
     * Steps the time counter in the store with one
     */

    public void step() {
	for(Register r : registers) {
	    
	    r.step();
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
     * Return all done customers in the current time step
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
	String s = null;
	for(Register r : registers) {
	    s = r.toString() + "\n";
	}
	return s;
    }
}
