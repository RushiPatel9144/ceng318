package lab07.task3;

public class BinaryTree {
    private TreeNode root;

    // Add product based on productID
    public void addProduct(Product product) {
        root = addRecursive(root, product);
    }

    private TreeNode addRecursive(TreeNode current, Product product) {
        if (current == null) {
            return new TreeNode(product);
        }
        if (product.getProductID() < current.getElement().getProductID()) {
            current.setLeft(addRecursive(current.getLeft(), product));
        } else if (product.getProductID() > current.getElement().getProductID()) {
            current.setRight(addRecursive(current.getRight(), product));
        }
        return current;
    }

    // Search for a product by productID
    public TreeNode searchProduct(int productID) {
        return searchRecursive(root, productID);
    }

    private TreeNode searchRecursive(TreeNode current, int productID) {
        if (current == null || current.getElement().getProductID() == productID) {
            return current;
        }
        return productID < current.getElement().getProductID()
                ? searchRecursive(current.getLeft(), productID)
                : searchRecursive(current.getRight(), productID);
    }

    // Display all products in post-order
    public void displayInventory() {
        postOrderTraversal(root);
    }

    private void postOrderTraversal(TreeNode node) {
        if (node != null) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            System.out.println(node.getElement());
        }
    }

    // Remove product by productID
    public void removeProduct(int productID) {
        root = removeRecursive(root, productID);
    }

    private TreeNode removeRecursive(TreeNode current, int productID) {
        if (current == null) {
            return null;
        }

        if (productID == current.getElement().getProductID()) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            } else if (current.getLeft() == null) {
                return current.getRight();
            } else if (current.getRight() == null) {
                return current.getLeft();
            } else {
                TreeNode smallestValue = findSmallestValue(current.getRight());
                current.setElement(smallestValue.getElement());
                current.setRight(removeRecursive(current.getRight(), smallestValue.getElement().getProductID()));
            }
        } else if (productID < current.getElement().getProductID()) {
            current.setLeft(removeRecursive(current.getLeft(), productID));
        } else {
            current.setRight(removeRecursive(current.getRight(), productID));
        }
        return current;
    }

    private TreeNode findSmallestValue(TreeNode root) {
        return root.getLeft() == null ? root : findSmallestValue(root.getLeft());
    }
}
