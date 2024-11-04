package lab07.task3;

public class TreeNode {
    private Product element;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Product element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    public Product getElement() {
        return element;
    }

    public void setElement(Product element) {
        this.element = element;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
