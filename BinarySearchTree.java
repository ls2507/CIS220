//LUIS MIRANDA
//CHPT 7 PA

class BinarySearchTree {
	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public Node getRoot() {
		return root;
	}

	public Node search(int desiredKey) {
		System.out.println("\nSearching for node " + desiredKey);
		Node currentNode = root;
		while (currentNode != null) {
			// Return the node if the key matches
			if (currentNode.key == desiredKey) {
				return currentNode;
			}
 		    // Navigate to the right
			else if (desiredKey < currentNode.key) {
				System.out.print("\nDid not find node, navigating to node " + currentNode.key + "'s left child");   
				currentNode = currentNode.left;
			}
			// Navigate to the right 
			else {
				System.out.print("\nDid not find node, navigating to node " + currentNode.key + "'s right child");         
				currentNode = currentNode.right;
			}
		}
		// The key was not found in the tree.
		return null;
	}

	public void insert(Node node) {
		System.out.println("Inserting node " + node.key);
		// Check if tree is empty
		if (root == null) {
			root = node;
			System.out.println("Inserted node " + node.key + " as the root node.\n");
		} else {
			Node currentNode = root;
			while (currentNode != null) {
				if (node.key < currentNode.key) {
					// If no left child exists, add the new node
					System.out.println("Checking node " + currentNode.key + " for left child.");
					if (currentNode.left == null) {
						System.out.println("Inserting node " + node.key + " as left child of node " + currentNode.key +".\n");
						currentNode.left = node;
						currentNode = null;
					} else {
						currentNode = currentNode.left;
						System.out.println("Traversed to left child node " + currentNode.key +".");
					}
				} else {
					// If no right child exists, add the new node
					System.out.println("Checking node " + currentNode.key + " for right child.");
					if (currentNode.right == null) {
						System.out.println("Inserting node " + node.key + " as right child of node " + currentNode.key +".\n");  
						currentNode.right = node;
						currentNode = null;
					} else {
						currentNode = currentNode.right;
						System.out.println("Traversed to right child node " + currentNode.key +".");
					}
				}
			}
		}
	}

	public boolean remove(int key) {
		root = removeNode(root, key);
		return true;
	}

	private Node removeNode(Node root, int key) {
		if (root == null)
			return root;

		if (key < root.key) {
			root.left = removeNode(root.left, key);
		} else if (key > root.key) {
			root.right = removeNode(root.right, key);
		} else {
			// Node with only <= 1 child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// Node with two children
			root.key = minValue(root.right);

			// Delete the inorder successor
			root.right = removeNode(root.right, root.key);
		}
		return root;
	}

	private int minValue(Node root) {
		int minValue = root.key;
		while (root.left != null) {
			minValue = root.left.key;
			root = root.left;
		}
		return minValue;
	}
}
