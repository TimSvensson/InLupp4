public class Register {

    private boolean open;
    private Queue<Customer> queue;

    public Register() {
	this.open = false;
	this.queue = new Queue<Customer>();
    }

    public void open() {
	this.open = true;
    }

    public void close() {
	this.open = false;
    }

    public boolean isOpen() {
	return this.open;
    }

    public void step() {
	if(hasCustomers()) {
	    if(!currentCustomerIsDone()) {
		this.queue.first().serve();
	    }
	}
    }

    public boolean hasCustomers() {
	if (getQueueLength() > 0) { return true; }
	else { return false; }
    }

    public boolean currentCustomerIsDone() {
	Customer c;
	try {
	    c = this.queue.first();
	} catch (NullPointerException e) {
	    return false;
	}
	return c.isDone();
    }

    public void addToQueue(Customer c) {
	this.queue.enqueue(c);
    }

    public Customer removeCurrentCustomer() {
	Customer c;
	try {
	    c = this.queue.dequeue();
	} catch (NullPointerException e) {
	    c = null;
	}
	return c;
    }

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
	    s = "   [" + this.queue.first().getGroceries()  + "]" + this.queue.toString();
	} else if (this.isOpen()) {
	    s = "   [ ]";
	} else {
	    s = " x [ ]";
	}
	return s;
    }
}
