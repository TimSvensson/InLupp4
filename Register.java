/**
 * This class provides methodes for the registers
 */

public class Register {

    private boolean open;
    private Queue<Customer> queue;


 	/**
     * Creates the register
     */

    public Register() {
	this.open = false;
	this.queue = new Queue<Customer>();
    }

    /**
     * Opens the register
     */
    public void open() {
	this.open = true;
    }

    /**
     * Closes the register
     */
    public void close() {
	this.open = false;
    }

    /**
     * Checks wheter the register is open or not
     */
    public boolean isOpen() {
	return this.open;
    }

    /**
     * Steps the time counter with one
     */
    public void step() {
	if(hasCustomers()) {
	    if(!currentCustomerIsDone()) {
		this.queue.first().serve();
	    }
	} else {
	    close();
	}
    }

    /**
     * Checks wheter the register has customers or not
     */
    public boolean hasCustomers() {
	if (getQueueLength() > 0) { return true; }
	else { return false; }
    }

    /**
     * Checks wheter the current customer is done or not
     */
    public boolean currentCustomerIsDone() {
	Customer c;
	try {
	    c = this.queue.first();
	} catch (NullPointerException e) {
	    return false;
	}
	return c.isDone();
    }
    /**
     * Adds a customer last in the queue
     *
     * @param the customer
     */
    public void addToQueue(Customer c) {
	this.queue.enqueue(c);
    }

    /**
     * Removes and returns the last customer in the queue
     */
    public Customer removeCurrentCustomer() {
	Customer c;
	try {
	    c = this.queue.dequeue();
	} catch (NullPointerException e) {
	    c = null;
	}
	return c;
    }

    /**
     * Finds out how long the queue is
     */
    public int getQueueLength() {
	int length = -1;
	try {
	    length = this.queue.length();
	} catch (NullPointerException e) {
	    length = 0;
	}
	return length;
    }

    public String toString() {
	String s = null;

	if(this.isOpen() && this.hasCustomers()) {
	    if (this.queue.first().getGroceries() < 10) {
		s = "   [ " + this.queue.first().getGroceries()  + "]" + this.queue.toString();
	    } else {
		s = "   [" + this.queue.first().getGroceries()  + "]" + this.queue.toString();
	    }
	} else if (this.isOpen()) {
	    s = "   [  ]";
	} else {
	    s = " x [  ]";
	}
	return s;
    }
}
