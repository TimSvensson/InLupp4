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
	if(getQueueLength() > 0) { return true; }
	else { return false; }
    }

    public boolean currentCustomerIsDone() {
	Customer c = this.queue.first();
	return c.isDone();
    }

    public void addToQueue(Customer c) {
	this.queue.enqueue(c);
    }

    public Customer removeCurrentCustomer() {
	return this.queue.dequeue();
    }

    public int getQueueLength() {
	return this.queue.length();
    }

    public String toString() {
	String s = null;

	if(this.isOpen()) {
	    s = "[" + this.queue.first().getGroceries()  + "]" + this.queue.toString();
	} else {
	    s = " x [ ]";
	}
	return s;
    }
}
