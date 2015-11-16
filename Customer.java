public class Customer {
    private int bornTime;
    private int groceries;

    //KONSTRUKTOR;
    public Customer(int time, int groceries) {
	    this.bornTime = time;
	    this.groceries = groceries;
    }

    //METODER;
    public void serve() {
	groceries--;
    }
    public boolean isDone() {
	return groceries == 0;
    }
    public int getGroceries() {
	return this.groceries;
    }
    public int getBornTime() {
	return this.bornTime;
    }
    public String toString() {
	return "@";
    }
}
