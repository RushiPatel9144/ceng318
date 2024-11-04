package lab07.task1;
public class BinaryTree extends Tree {
    public TreeNode addLeft(TreeNode parent, Employee employee) {
        if (parent.getChildren().size() > 0 && parent.getChildren().get(0) != null) {
            throw new IllegalArgumentException("Left child already exists.");
        }
        TreeNode leftChild = new TreeNode(employee, parent);
        parent.getChildren().add(0, leftChild);
        size++;
        return leftChild;
    }

    public TreeNode addRight(TreeNode parent, Employee employee) {
        if (parent.getChildren().size() > 1 && parent.getChildren().get(1) != null) {
            throw new IllegalArgumentException("Right child already exists.");
        }
        if (parent.getChildren().size() == 0) parent.getChildren().add(null);
        TreeNode rightChild = new TreeNode(employee, parent);
        if (parent.getChildren().size() == 1) {
            parent.getChildren().add(rightChild);
        } else {
            parent.getChildren().set(1, rightChild);
        }
        size++;
        return rightChild;
    }
}
