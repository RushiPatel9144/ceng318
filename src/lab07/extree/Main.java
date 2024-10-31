package lab07.extree;
public class Main {

        public static void main(String[] args) {

            // ===============================================================
            System.out.println("===== Testing Tree Class =====");
            Tree tree = new Tree();
            TreeNode root = tree.addRoot(1);
            TreeNode child1 = tree.addChild(root, 2);
            TreeNode child2 = tree.addChild(root, 3);

            TreeNode child1a = tree.addChild(child1, 4);
            TreeNode child1b = tree.addChild(child1, 5);

            System.out.println("Tree Size: " + tree.size()); // Expected: 5
            System.out.println("Tree Root: " + tree.root().getElement()); // Expected: 1
            System.out.println("Tree Root is Root: " + tree.isRoot(root)); // Expected: true
            System.out.println("Node 2 is Internal: " + tree.isInternal(child1)); // Expected: true
            System.out.println("Node 4 is External: " + tree.isExternal(child1a)); // Expected: true

            // Replace node element
            tree.replace(child1a, 6);
            System.out.println("Replaced 4 with: " + child1a.getElement()); // Expected: 6
            System.out.println("Height of Tree : " + tree.height()); //

            // ===============================================================
            System.out.println("\n===== Testing Binary Tree Class =====");
            BinaryTree binaryTree = new BinaryTree();
            TreeNode binaryRoot = binaryTree.addRoot(10);

            // Add left and right children to the root
            TreeNode leftChild = binaryTree.addLeft(binaryRoot, 5);
            TreeNode rightChild = binaryTree.addRight(binaryRoot, 15);

            // Add more nodes to build the binary tree
            binaryTree.addLeft(leftChild, 3);
            binaryTree.addRight(leftChild, 7);

            binaryTree.addLeft(rightChild, 13);
            binaryTree.addRight(rightChild, 18);

            // Print the structure of the binary tree
            binaryTree.printTree(binaryRoot, "", false);

            // Traversal examples (assuming traversal methods exist)
            System.out.println("\nPreorder Traversal:");
            binaryTree.preOrderTraversal(binaryRoot);

            System.out.println("\nInorder Traversal:");
            binaryTree.inOrderTraversal(binaryRoot);

            System.out.println("\nPostorder Traversal:");
            binaryTree.postOrderTraversal(binaryRoot);

            // ===============================================================
            System.out.println("\n===== Testing Binary Search Tree (BST) Class =====");
            BinarySearchTree bst = new BinarySearchTree();
            bst.addToBST(10);
            bst.addToBST(5);
            bst.addToBST(15);
            bst.addToBST(3);
            bst.addToBST(7);
            bst.addToBST(13);
            bst.addToBST(18);

            // Print the structure of the BST
            bst.printTree(bst.root(), "", false);

            // Search for nodes
            System.out.println("\nSearching for 7: " + (bst.searchInBST(7) != null ? "Found" : "Not Found")); // Expected: Found
            System.out.println("Searching for 20: " + (bst.searchInBST(20) != null ? "Found" : "Not Found")); // Expected: Not Found

            // Delete a node and print the tree again
            System.out.println("\nDeleting 5");
            bst.removeFromBST(5);
            bst.printTree(bst.root(), "", false);
        }
    }


