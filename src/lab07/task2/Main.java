package lab07.task2;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Random random = new Random();

        // Insert 1,000 random transactions and measure time
        System.out.println("===== Inserting 1,000 Transactions =====");
        long startTime = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            Transaction transaction = generateRandomTransaction(i, random);
            bst.insertTransaction(transaction);
        }
        long endTime = System.nanoTime();
        System.out.println("Insertion Time for 1,000 Transactions: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // Measure time for viewing all transactions (in-order traversal)
        System.out.println("\n===== Viewing All Transactions =====");
        startTime = System.nanoTime();
        bst.viewAllTransactions();
        endTime = System.nanoTime();
        System.out.println("Traversal Time for Viewing All Transactions: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // Measure time for searching for a transaction with ID 500
        System.out.println("\n===== Searching for Transaction with ID 500 =====");
        startTime = System.nanoTime();
        TreeNode result = bst.searchTransaction(500);
        endTime = System.nanoTime();
        System.out.println(result != null ? "Found: " + result.getElement() : "Transaction not found");
        System.out.println("Search Time for Transaction ID 500: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // Measure time for deleting a transaction with ID 250
        System.out.println("\n===== Deleting Transaction with ID 250 =====");
        startTime = System.nanoTime();
        bst.deleteTransaction(250);
        endTime = System.nanoTime();
        System.out.println("Deletion Time for Transaction ID 250: " + (endTime - startTime) / 1_000_000.0 + " ms");

        // View all transactions again after deletion to verify changes
        System.out.println("\n===== Viewing All Transactions After Deletion =====");
    }

    // Helper method to generate random transactions with a given ID
    private static Transaction generateRandomTransaction(int transactionID, Random random) {
        int customerID = random.nextInt(1000) + 1;
        String date = "2024-0" + (random.nextInt(9) + 1) + "-" + (random.nextInt(28) + 1); // Random date
        double amount = random.nextDouble() * 1000; // Random amount between 0 and 1000
        return new Transaction(transactionID, customerID, date, amount);
    }
}

//Task 2
//        Insertion Time for 100 Transactions: 18.4718 ms
//        Traversal Time for Viewing All Transactions: 17.8838 ms
//        Search Time for Transaction ID 50: 0.0378 ms
//        Deletion Time for Transaction ID 25: 0.0435 ms
//
//        Insertion Time for 500 Transactions: 23.4543 ms
//        Search Time for Transaction ID 250: 0.0627 ms
//        Deletion Time for Transaction ID 125: 0.0456 ms
//        Traversal Time for Viewing All Transactions: 36.8782 ms
//
//        Insertion Time for 1,000 Transactions: 29.9018 ms
//        Traversal Time for Viewing All Transactions: 50.5199 ms
//        Search Time for Transaction ID 500: 0.1657 ms
//        Deletion Time for Transaction ID 250: 0.112 ms
