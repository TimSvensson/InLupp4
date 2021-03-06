/**
 * This class provides methods for a customer
 */

public class Customer {
    private int bornTime;
    private int groceries;

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

    /**
     * Remove one ware from the customer's wares
     */
    public void serve() {
	if (groceries > 0) {
	    groceries--;
	}
    }

    /**
     * Checks if the customers groceries are zero
     */
    public boolean isDone() {
	return groceries == 0;
    }

    /**
    * Returns the customers amount of groceries
    */
    public int getGroceries() {
	return this.groceries;
    }

    /**
    *Returns the customers borntime
    */
    public int getBornTime() {
	return this.bornTime;
    }

    public String toString() {
	return "@";
    }
}
