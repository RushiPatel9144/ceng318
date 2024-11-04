package lab07.task1;
import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private Employee employee;
    private TreeNode parent;
    private List<TreeNode> children;

    public TreeNode(Employee employee, TreeNode parent) {
        this.employee = employee;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public Employee getEmployee() {
        return employee;
    }

    public TreeNode getParent() {
        return parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getElement() {
        return 0;
    }
}
