package lab07.extree;

public class BinaryTree extends Tree {

    // Method to add a left child
    public TreeNode addLeft(TreeNode parent, Integer element) {
        if (getLeftChild(parent) != null) {
            throw new IllegalArgumentException("Left child already exists.");
        }
        TreeNode leftChild = new TreeNode(element, parent);
        parent.getChildren().add(0, leftChild); // Add as left child
        size++;
        return leftChild;
    }

    // Method to add a right child
    public TreeNode addRight(TreeNode parent, Integer element) {
        if (getRightChild(parent) != null) {
            throw new IllegalArgumentException("Right child already exists.");
        }
        // Ensure left slot exists if only right is being added
        if (parent.getChildren().size() == 0) {
            parent.getChildren().add(null); // Placeholder for left child
        }
        TreeNode rightChild = new TreeNode(element, parent);
        if (parent.getChildren().size() == 1) {
            parent.getChildren().add(rightChild); // Add as right child
        } else {
            parent.getChildren().set(1, rightChild); // Replace existing right child
        }
        size++;
        return rightChild;
    }

    // Traversal methods
    public void preOrderTraversal(TreeNode node) {
        if (node == null) return;
        System.out.print(node.getElement() + " ");
        preOrderTraversal(getLeftChild(node));  // Left
        preOrderTraversal(getRightChild(node)); // Right
    }

    public void inOrderTraversal(TreeNode node) {
        if (node == null) return;
        inOrderTraversal(getLeftChild(node));   // Left
        System.out.print(node.getElement() + " ");
        inOrderTraversal(getRightChild(node));  // Right
    }

    public void postOrderTraversal(TreeNode node) {
        if (node == null) return;
        postOrderTraversal(getLeftChild(node));  // Left
        postOrderTraversal(getRightChild(node)); // Right
        System.out.print(node.getElement() + " ");
    }

    // Method to print the structure of the tree
    public void printTree(TreeNode root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.getElement());
            printTree(getLeftChild(root), prefix + (isLeft ? "│   " : "    "), true);
            printTree(getRightChild(root), prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    // Helper method to get the left child of a node
    TreeNode getLeftChild(TreeNode node) {
        if (node.getChildren().size() > 0) {
            return node.getChildren().get(0); // Left child
        }
        return null;
    }

    // Helper method to get the right child of a node
    TreeNode getRightChild(TreeNode node) {
        if (node.getChildren().size() > 1) {
            return node.getChildren().get(1); // Right child
        }
        return null;
    }
}
