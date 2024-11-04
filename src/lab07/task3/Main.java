package lab07.task3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BinaryTree productTree = new BinaryTree();
        Random rand = new Random();

        // ===== Inserting 1000 products =====
        System.out.println("===== Inserting 1000 Products =====");
        long startTime = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            Product product = new Product(i, "Product " + i, rand.nextDouble() * 100, rand.nextInt(50) + 1);
            productTree.addProduct(product); // Insert directly into the binary tree
        }
        long endTime = System.nanoTime();
        System.out.println("Insertion Time: " + (endTime - startTime) / 1e6 + " ms");

        // ===== Searching for a specific product =====
        int searchID = 500; // Search for a product with ID 500
        System.out.println("\n===== Searching for Product with ID " + searchID + " =====");
        startTime = System.nanoTime();
        TreeNode searchResult = productTree.searchProduct(searchID);
        endTime = System.nanoTime();
        System.out.println(searchResult != null ? "Found: " + searchResult.getElement() : "Product not found");
        System.out.println("Search Time: " + (endTime - startTime) / 1e6 + " ms");

        // ===== Displaying all products in post-order =====
        System.out.println("\n===== Displaying Inventory in Post-Order =====");
        startTime = System.nanoTime();
        productTree.displayInventory(); // Perform post-order traversal to display inventory
        endTime = System.nanoTime();
        System.out.println("Traversal Time: " + (endTime - startTime) / 1e6 + " ms");

        // ===== Removing a specific product =====
        int removeID = 100; // Remove a product with ID 100
        System.out.println("\n===== Removing Product with ID " + removeID + " =====");
        startTime = System.nanoTime();
        productTree.removeProduct(removeID);
        endTime = System.nanoTime();
        System.out.println("Deletion Time: " + (endTime - startTime) / 1e6 + " ms");

        // ===== Displaying updated inventory =====
        System.out.println("\n===== Displaying Updated Inventory in Post-Order =====");

    }
}
//Task 3
//        100 transactions
//        Insertion Time: 9.4417 ms
//        Search Time: 0.0185 ms
//        Traversal Time: 7.4684 ms
//        Deletion Time: 0.0157 ms
//
//        500 transactions
//        Insertion Time: 16.19 ms
//        Search Time: 0.0498 ms
//        Traversal Time: 33.3146 ms
//        Deletion Time: 0.0171 ms
//
//        1000 transaction
//        Insertion Time: 21.6785 ms
//        Search Time: 0.1028 ms
//        Traversal Time: 26.9309 ms
//        Deletion Time: 0.0462 ms
