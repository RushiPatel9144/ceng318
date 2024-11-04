package lab07.task2;

public class BinarySearchTree {
    private TreeNode root;

    // Insert a new transaction based on transactionID
    public TreeNode insertTransaction(Transaction transaction) {
        if (this.root == null) {
            root = new TreeNode(transaction, null);
            return root;
        }
        return addTransaction(this.root, transaction);
    }

    // Helper method to recursively add a transaction
    private TreeNode addTransaction(TreeNode node, Transaction transaction) {
        if (transaction.getTransactionID() < node.getElement().getTransactionID()) {
            if (node.getChildren().isEmpty() || node.getChildren().get(0) == null) {
                TreeNode leftChild = new TreeNode(transaction, node);
                node.getChildren().add(0, leftChild);
                return leftChild;
            } else {
                return addTransaction(node.getChildren().get(0), transaction);
            }
        } else {
            if (node.getChildren().size() < 2 || node.getChildren().get(1) == null) {
                TreeNode rightChild = new TreeNode(transaction, node);
                if (node.getChildren().size() < 2) node.getChildren().add(rightChild);
                else node.getChildren().set(1, rightChild);
                return rightChild;
            } else {
                return addTransaction(node.getChildren().get(1), transaction);
            }
        }
    }

    // Delete a transaction by transactionID
    public TreeNode deleteTransaction(Integer transactionID) {
        return removeTransaction(this.root, transactionID);
    }

    private TreeNode removeTransaction(TreeNode node, Integer transactionID) {
        if (node == null) return null;
        if (transactionID < node.getElement().getTransactionID()) {
            if (!node.getChildren().isEmpty()) node.getChildren().set(0, removeTransaction(node.getChildren().get(0), transactionID));
        } else if (transactionID > node.getElement().getTransactionID()) {
            if (node.getChildren().size() > 1) node.getChildren().set(1, removeTransaction(node.getChildren().get(1), transactionID));
        } else {
            if (node.getChildren().isEmpty()) return null;
            if (node.getChildren().size() == 1) return node.getChildren().get(0);
            if (node.getChildren().size() > 1) {
                TreeNode minNode = findMin(node.getChildren().get(1));
                node.setElement(minNode.getElement());
                node.getChildren().set(1, removeTransaction(node.getChildren().get(1), minNode.getElement().getTransactionID()));
            }
        }
        return node;
    }

    private TreeNode findMin(TreeNode node) {
        while (!node.getChildren().isEmpty() && node.getChildren().get(0) != null) {
            node = node.getChildren().get(0);
        }
        return node;
    }

    // Search for a transaction by transactionID
    public TreeNode searchTransaction(Integer transactionID) {
        return searchTransaction(this.root, transactionID);
    }

    private TreeNode searchTransaction(TreeNode node, Integer transactionID) {
        if (node == null) return null;
        if (transactionID.equals(node.getElement().getTransactionID())) {
            return node;
        } else if (transactionID < node.getElement().getTransactionID()) {
            return searchTransaction(node.getChildren().isEmpty() ? null : node.getChildren().get(0), transactionID);
        } else {
            return searchTransaction(node.getChildren().size() < 2 ? null : node.getChildren().get(1), transactionID);
        }
    }

    // View all transactions in ascending order
    public void viewAllTransactions() {
        System.out.println("Transactions in ascending order:");
        inOrderTraversal(this.root);
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) return;
        if (!node.getChildren().isEmpty()) inOrderTraversal(node.getChildren().get(0));
        System.out.println(node.getElement());
        if (node.getChildren().size() > 1) inOrderTraversal(node.getChildren().get(1));
    }
}
