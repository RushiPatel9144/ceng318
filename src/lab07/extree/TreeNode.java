package lab07.extree;
import java.util.ArrayList;
import java.util.List;

public class TreeNode {

/*
// ===== Approach #1 of implementation of Binary Tree
    class TreeNode {
        private Integer element;
        private TreeNode left;  // Reference to the left child
        private TreeNode right; // Reference to the right child

        public TreeNode(Integer element) {
            this.element = element;
            this.left = null;
            this.right = null;
        }
    }
*/



    private Integer element; // value of the current node
    private TreeNode parent; // parent of the current node
    private List<TreeNode> children; // list of children of the current node

    public TreeNode(Integer element, TreeNode parent) {
        this.element = element;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public Integer getElement() {
        return element;
    }

    public TreeNode getParent() {
        return parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setElement(Integer element) {
        this.element = element;
    }
}
