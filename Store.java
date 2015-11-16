public class Store { 
    Register[] registers;
   
    int numberOfRegisters;
    int thresholdForNewRegister;

    public Store(int numberOfRegisters, int thresholdForNewRegister) {
	this.numberOfRegisters = numberOfRegisters;
	this.thresholdForNewRegister = thresholdForNewRegister;

	registers = new Register[numberOfRegisters];

	for(Register r : registers) {
	    r = new Register();
	}
    }

    public int getAverageQueueLength() {
	int lengthOfAllQueues = 0;

	for(Register r : registers) {
	    lengthOfAllQueues += r.getQueueLength();
	}

	return lengthOfAllQueues / this.numberOfRegisters;
    }

    public void newCustomer(Customer c) {
	Register r = this.getShortestQueue();
	r.addToQueue(c);
    }

    private Register getShortestQueue() {
	Register shortest = this.registers[0];

	for(Register r : this.registers) {
	    if(r.isOpen()) {
		if(r.getQueueLength() < shortest.getQueueLength()) {
		    shortest = r;
		}
	    }
	}
	return shortest;
    }

    public void step() {
	for(Register r : registers) {
	    r.step();
	}
    }

    public void openNewRegister() {
	for(Register r : registers) {
	    if(!r.isOpen()) {
		r.open();
		break;
	    }
	}
    }

    public void getDoneCustomers() {
	
    }

    public String toString() {
	String s = null;

	for(Register r : registers) {
	    s = r.toString() + "\n";
	}
	return s;
    }
}
