package lab07.task2;
import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private Transaction element;
    private TreeNode parent;
    private List<TreeNode> children;

    public TreeNode(Transaction element, TreeNode parent) {
        this.element = element;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public Transaction getElement() {
        return element;
    }

    public void setElement(Transaction element) {
        this.element = element;
    }

    public TreeNode getParent() {
        return parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }
}
