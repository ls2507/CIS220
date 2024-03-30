public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    public Node search(int desiredKey) {
        // Implementation of search method
        return null; // Placeholder, replace with actual implementation
    }

    public void insert(Node node) {
        // Implementation of insert method
    }

    public boolean remove(int key) {
        root = removeNode(root, key);
        return root != null; // Return false if root is null (key not found), true otherwise
    }

    private Node removeNode(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.key) {
            root.left = removeNode(root.left, key);
        } else if (key > root.key) {
            root.right = removeNode(root.right, key);
        } else {
            // Node to be deleted found

            // Case 1: Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node with two children, get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = removeNode(root.right, root.key);
        }
        return root;
    }

    private int minValue(Node node) {
        int minValue = node.key;
        while (node.left != null) {
            minValue = node.left.key;
            node = node.left;
        }
        return minValue;
    }
}



class BST_Demo {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert nodes
        tree.insert(new Node(20));
        tree.insert(new Node(35));
        tree.insert(new Node(13));
        tree.insert(new Node(6));
        tree.insert(new Node(24));
        tree.insert(new Node(18));
        tree.insert(new Node(48));
        tree.insert(new Node(1));
        tree.insert(new Node(27));

        // Print initial tree
        BSTPrint.print2D(tree.getRoot());

        // Remove nodes 18 and 48
        tree.remove(18);
        tree.remove(48);

        // Print tree after removal
        BSTPrint.print2D(tree.getRoot());

        // Insert nodes 16 and 45
        tree.insert(new Node(16));
        tree.insert(new Node(45));

        // Print tree after insertion
        BSTPrint.print2D(tree.getRoot());

        // Remove nodes 6 and 24
        tree.remove(6);
        tree.remove(24);

        // Print tree after removal
        BSTPrint.print2D(tree.getRoot());

        // Remove node 20 and attempt to remove node 38
        tree.remove(20);
        tree.remove(38); // Node 38 not in tree

        // Print tree after removal
        BSTPrint.print2D(tree.getRoot());
    }
}
