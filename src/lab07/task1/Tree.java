package lab07.task1;
import java.util.ArrayList;
import java.util.List;

public class Tree {
    protected TreeNode root;
    protected int size = 0;

    public Tree() {
        root = null;
        size = 0;
    }

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

    public boolean isInternal(TreeNode node) {
        return !node.getChildren().isEmpty();
    }

    public boolean isExternal(TreeNode node) {
        return node.getChildren().isEmpty();
    }

    public boolean isRoot(TreeNode node) {
        return node == root;
    }

    public Employee replace(TreeNode node, Employee employee) {
        Employee oldEmployee = node.getEmployee();
        node.setEmployee(employee);
        return oldEmployee;
    }

    public TreeNode addRoot(Employee employee) {
        if (root != null) throw new IllegalStateException("Tree already has a root");
        root = new TreeNode(employee, null);
        size = 1;
        return root;
    }

    public TreeNode addChild(TreeNode parent, Employee employee) {
        TreeNode child = new TreeNode(employee, parent);
        parent.getChildren().add(child);
        size++;
        return child;
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null) return -1;
        int maxHeight = -1;
        for (TreeNode child : node.getChildren()) {
            maxHeight = Math.max(maxHeight, height(child));
        }
        return maxHeight + 1;
    }

    public TreeNode findEmployee(int employeeID) {
        return findEmployee(root, employeeID);
    }

    private TreeNode findEmployee(TreeNode node, int employeeID) {
        if (node == null) return null;
        if (node.getEmployee().getEmployeeID() == employeeID) return node;
        for (TreeNode child : node.getChildren()) {
            TreeNode foundNode = findEmployee(child, employeeID);
            if (foundNode != null) return foundNode;
        }
        return null;
    }

    public void printTree(TreeNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getEmployee().getName());
            for (int i = 0; i < node.getChildren().size(); i++) {
                printTree(node.getChildren().get(i), prefix + (isLeft ? "│   " : "    "), i == node.getChildren().size() - 1);
            }
        }
    }

    public void preOrderTraversal(TreeNode node) {
        if (node == null) return;
        System.out.print(node.getEmployee().getName() + " ");
        for (TreeNode child : node.getChildren()) {
            preOrderTraversal(child);
        }
    }

    public void inOrderTraversal(TreeNode node) {
        if (node == null) return;
        int size = node.getChildren().size();
        if (size > 0) inOrderTraversal(node.getChildren().get(0));
        System.out.print(node.getEmployee().getName() + " ");
        for (int i = 1; i < size; i++) {
            inOrderTraversal(node.getChildren().get(i));
        }
    }

    public void postOrderTraversal(TreeNode node) {
        if (node == null) return;
        for (TreeNode child : node.getChildren()) {
            postOrderTraversal(child);
        }
        System.out.print(node.getEmployee().getName() + " ");
    }

    public void addEmployee(TreeNode root, Employee newEmployee) {
    }
}
