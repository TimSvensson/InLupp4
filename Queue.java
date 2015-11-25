
/**
 * This class provides methodes for the queue
 */

public class Queue<T> {
    private Node first;
    private Node last; 
    private int length; 
    
    private class Node {
	private T element;
	private Node next;
	
	/**
	 * Creates a Node
	 *
	 * @param The element the node contains
	 */
	public Node (T element) {
	    this.element = element;
	    next = null;
	}
	
	public String toString() {
	    return element.toString();
	}
    }

    /**
     * Creates a queue
     */

    public Queue () {
	first = null;
	last = null;
	this.length = 0;
    }

    /**
     * The length of the queue
     */
    public int length() {
	return length; 
    }

    /**
     * Sets a element last in the queue
     *
     * @param the element
     */
    public void enqueue(T element) {
	
	Node newNode = new Node(element);
	if(first == null) {
	    first = newNode;
	}
	else {
	    last.next = newNode;
	}
	last = newNode;
	length++;
    }

    /**
     * Removes the first customer in queue
     */

    public T dequeue() {
	T firstElement = first.element;
	this.first = this.first.next;
	this.length = this.length -1;
	return firstElement;
    }

    /**
     * Returns the first customer in queue
     */
    public T first() {
	return this.first.element;
    }
    public String toString() {
	Node n = this.first;
	String s = "";

	while(n != null) {
	    s += n.toString();
	    n = n.next;
	}
	return s;
    }
}
