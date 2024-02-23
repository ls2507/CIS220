// LinkedList.java
//Luis Miranda
//Chpt4 PA
public class LinkedList { 

    private Node head;
    private Node tail;

    // Constructor to create a LinkedList object/instance
    public LinkedList() { 
       head = null;
       tail = null;
    }
    
    // Get methods to return the head or tail Nodes
    public Node getHead() {
        return this.head;
    }
    
    public Node getTail() {
        return this.tail;
    }

    public void listAppend(Node newNode) {
        if (this.head == null) { // List empty
            this.head = newNode;
            this.tail = newNode;
        }
        else{
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    public void listPrepend(Node newNode) {
        if (this.head == null) { // list empty
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
    }

    public void listInsertAfter(Node curNode, Node newNode) {
        if (this.head == null) { // list empty
            this.head = newNode;
            this.tail = newNode;
        }
        else if (curNode == this.tail) { // Insert after tail
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        else {
            newNode.setNext(curNode.getNext());
            curNode.setNext(newNode);
        }
    }

    public void listRemoveNodeAfter(Node curNode) {
        // Special case, remove head
        if (curNode == null && this.head != null) {
            Node sucNode = this.head.getNext();
            this.head = sucNode;
            if (sucNode == null) { // Removed last item
                this.tail = null;
            }
        }
        else if (curNode.getNext() != null) {
            Node sucNode = curNode.getNext().getNext();
            curNode.setNext(sucNode);

            if (sucNode == null) { // Removed tail
                this.tail = curNode;
            }
        }
    }

    public Node listSearch(int key) {
        Node curNode = this.head;
        while (curNode != null) {
            if (curNode.getData() == key) {
                return curNode;
            }
        curNode = curNode.getNext();
        }
        return null;
    }

    public void listTraverse() {
        Node curNode = this.head; // Start at head
        System.out.print("The list order is: "); 
        while (curNode != null) { 
            System.out.print(curNode.getData() + " ");     
            curNode = curNode.getNext();
        }
        System.out.println();
    }
    
    // New method to sum data values
    public int sumDataValues() {
        int sum = 0;
        Node curNode = this.head;
        while (curNode != null) {
            sum += curNode.getData();
            curNode = curNode.getNext();
        }
        return sum;
    }
}

