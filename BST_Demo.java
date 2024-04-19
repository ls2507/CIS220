public class BST_Demo {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert nodes
        bst.insert(new Node(20));
        bst.insert(new Node(35));
        bst.insert(new Node(13));
        bst.insert(new Node(6));
        bst.insert(new Node(24));
        bst.insert(new Node(18));
        bst.insert(new Node(48));
        bst.insert(new Node(1));
        bst.insert(new Node(27));

        // Print 
        System.out.println("Initial Binary Search Tree:");
        BSTPrint.print2D(bst.getRoot());

        // Remove nodes 18 and 48
        bst.remove(18);
        bst.remove(48);
        System.out.println("Tree after removing 18 and 48:");
        BSTPrint.print2D(bst.getRoot());

        // Insert nodes 16 and 45
        bst.insert(new Node(16));
        bst.insert(new Node(45));
        System.out.println("Tree after inserting 16 and 45:");
        BSTPrint.print2D(bst.getRoot());

        // Remove nodes 6 and 24
        bst.remove(6);
        bst.remove(24);
        System.out.println("Tree after removing 6 and 24:");
        BSTPrint.print2D(bst.getRoot());

        // Remove node 20 and node 38
        bst.remove(20);
        bst.remove(38); 
        System.out.println("Tree after removing 20 and removing 38:");
        BSTPrint.print2D(bst.getRoot());
    }
}

