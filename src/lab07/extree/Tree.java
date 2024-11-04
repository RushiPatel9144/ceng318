package lab07.extree;

import java.util.List;

public class Tree {
    protected TreeNode root;
    protected int size = 0;

    // Constructor
    public Tree() {
        root = null;
        size = 0;
    }

    // Accessor Methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public TreeNode root() {
        return root;
    }

    public TreeNode parent(TreeNode node) {
        return node.getParent();
    }

    public Iterable<TreeNode> children(TreeNode node) {
        return node.getChildren();
    }

    // Query Methods
    public boolean isInternal(TreeNode node) {
        return !node.getChildren().isEmpty();
    }

    public boolean isExternal(TreeNode node) {
        return node.getChildren().isEmpty();
    }

    public boolean isRoot(TreeNode node) {
        return node == root;
    }

    // Update Method
    public Integer replace(TreeNode node, Integer element) {
        Integer oldElement = node.getElement();
        node.setElement(element);
        return oldElement;
    }

    // Method to add the root (if not already existing)
    public TreeNode addRoot(Integer element) {
        if (root != null) throw new IllegalStateException("Tree already has a root");
        root = new TreeNode(element, null);
        size = 1;
        return root;
    }

    // Method to add a child to a specific TreeNode
    public TreeNode addChild(TreeNode parent, Integer element) {
        TreeNode child = new TreeNode(element, parent);
        parent.getChildren().add(child);
        size++;
        return child;
    }

    // Method to calculate the height of the tree recursively
    public int height() {
        return height(root);
    }

    // Recursive method to calculate the height of the tree
    private int height(TreeNode node) {
        if (node == null) return -1; // If node is null, return -1
        int maxHeight = -1; // Initialize maximum height
        for (TreeNode child : node.getChildren()) {
            maxHeight = Math.max(maxHeight, height(child)); // Recursively get height of children
        }
        return maxHeight + 1; // Return height of the node
    }

    // Method to calculate the depth of a specific TreeNode recursively
    public int depth(TreeNode node) {
        return depth(node, root, 0);
    }

    // Recursive method to calculate the depth of a specific TreeNode
    private int depth(TreeNode target, TreeNode current, int currentDepth) {
        if (current == null) return -1; // Node not found
        if (current.equals(target)) return currentDepth; // Found the target node
        for (TreeNode child : current.getChildren()) {
            int childDepth = depth(target, child, currentDepth + 1); // Recur for children
            if (childDepth != -1) return childDepth; // Return depth if found
        }
        return -1; // Node not found
    }
}
