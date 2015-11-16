public class Queue<T> {
    private Node first;
    private Node last; 
    private int length; 
    
    private class Node {
	private T element;
	private Node next;
	
	public Node (T element) {
	    this.element = element;
	    next = null;
	}
    }
    public Queue () {
	first = null;
	last = null;
	this.length = 0;
    }
    public int length() {
	return length; 
    }
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
    public T dequeue() {
	T firstElement = first.element;
	if (this.first == null) {
	    throw new RuntimeException("The queue is empty");
	}
	else {
	    this.first = this.first.next;
	}
	this.length = this.length -1;
	return firstElement;
    }
    public T first() {
	if (this.first == null) {
	    throw new RuntimeException("The queue is empty");
	}
	else {
	    return this.first.element;
	}
    }
    public String toString() {
	Node n = this.first;
	String s = null;

	while(n != null) {
	    s += n.toString();
	    n = n.next;
	}
	return s;
    }
}
