// LinkedListTester.java
//Luis Miranda
//Chpt4 PA
public class LinkedListTester {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Append nodes
        list.listAppend(new Node(1));
        list.listAppend(new Node(2));
        
        list.listPrepend(new Node(3));
        
        list.listInsertAfter(list.getHead(), new Node(4));
        
        list.listAppend(new Node(5));
        
        list.listInsertAfter(list.listSearch(4), new Node(6));
        
        list.listInsertAfter(list.listSearch(2), new Node(7));
        
        list.listTraverse();
      
        list.listRemoveNodeAfter(null);
        
        list.listRemoveNodeAfter(list.listSearch(7));
        
        // Display the updated list
        list.listTraverse();
        
        // Search for node 5
        Node foundNode = list.listSearch(5);
        System.out.println("Node 5 " + (foundNode != null ? "found" : "not found"));
        
        // Search for node 2
        foundNode = list.listSearch(2);
        System.out.println("Node 2 " + (foundNode != null ? "found" : "not found"));
        
        // Sum of node values
        int sum = list.sumDataValues();
        System.out.println("The sum of the Linked List data values is: " + sum);
    }
}
