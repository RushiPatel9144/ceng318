package lab07.extree;

public class BinarySearchTree extends BinaryTree {

    // Method to add a new element into the BST
    public TreeNode addToBST(Integer element) {
        if (this.root == null) {
            return addRoot(element); // If tree is empty, add as root
        }
        return addToBST(this.root, element);
    }

    // Helper method to recursively add an element
    private TreeNode addToBST(TreeNode node, Integer element) {
        if (element < node.getElement()) {
            // Go left
            if (getLeftChild(node) != null) {
                return addToBST(getLeftChild(node), element);
            } else {
                return addLeft(node, element);
            }
        } else {
            // Go right
            if (getRightChild(node) != null) {
                return addToBST(getRightChild(node), element);
            } else {
                return addRight(node, element);
            }
        }
    }

    // Method to search for an element in the BST
    public TreeNode searchInBST(Integer element) {
        return searchInBST(this.root, element);
    }

    // Helper method to recursively search for an element
    private TreeNode searchInBST(TreeNode node, Integer element) {
        if (node == null || node.getElement().equals(element)) {
            return node; // Found or reached a leaf
        }
        if (element < node.getElement()) {
            return searchInBST(getLeftChild(node), element); // Go left
        } else {
            return searchInBST(getRightChild(node), element); // Go right
        }
    }

    // Method to remove an element from the BST
    public TreeNode removeFromBST(Integer element) {
        return removeFromBST(this.root, element);
    }

    // Helper method to recursively remove an element
    private TreeNode removeFromBST(TreeNode node, Integer element) {
        if (node == null) return null;

        if (element < node.getElement()) {
            // Go left
            node.getChildren().set(0, removeFromBST(getLeftChild(node), element));
        } else if (element > node.getElement()) {
            // Go right
            node.getChildren().set(1, removeFromBST(getRightChild(node), element));
        } else {
            // Node to be removed found
            if (node.getChildren().isEmpty()) {
                return null; // No children
            } else if (node.getChildren().size() == 1) {
                return node.getChildren().get(0); // One child
            } else {
                // Two children, find the minimum in the right subtree
                TreeNode minNode = findMin(getRightChild(node));
                node.setElement(minNode.getElement()); // Replace value
                node.getChildren().set(1, removeFromBST(getRightChild(node), minNode.getElement())); // Remove minNode
            }
        }
        return node;
    }

    // Method to find the minimum value node
    public TreeNode findMin(TreeNode node) {
        if (node == null) return null;
        while (getLeftChild(node) != null) {
            node = getLeftChild(node); // Move to leftmost node
        }
        return node;
    }

    // Method to find the maximum value node
    public TreeNode findMax(TreeNode node) {
        if (node == null) return null;
        while (getRightChild(node) != null) {
            node = getRightChild(node); // Move to rightmost node
        }
        return node;
    }

    // Helper method to find the maximum value in the entire tree
    public TreeNode findMax() {
        return findMax(this.root);
    }
}
