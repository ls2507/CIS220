// Class to hold the data and pointer of a Node
//Luis Miranda
//Chpt4 PA
public class Node { 

	private int data;
    private Node next;

	// Constructor to create a Node object/instance
    public Node(int item) { 
		data = item;
		next = null;
	}
	
	// Get methods
	public int getData() {
		return this.data;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	// Set methods
	public void setData(int data) {
		this.data = data;
	}
	
	public void setNext(Node node) {
		this.next = node;
	}

}
