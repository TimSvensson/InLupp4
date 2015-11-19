public class Customer {
    private int bornTime;
    private int groceries;

    //KONSTRUKTOR;

    /**
     * Creates a customer
     *
     * @param the required amount of groceries
     * @param the customers timestamp
     */
  

    public Customer(int time, int groceries) {
	    this.bornTime = time;
	    this.groceries = groceries;
    }

    //METODER;

    /**
     * Remove one ware from the customer's wares
     */

    public void serve() {
	groceries--;
    }

    /**
     * Checks if the customers groceries are zero
     */

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
