package TransactoinSystem;

import java.util.Stack;


import java.util.Stack;

public class TransactionPerformanceTest {

    public static void main(String[] args) {
        // Initialize the transaction history system
        TransactionHistorySystem transactionSystem = new TransactionHistorySystem();


        int[] testSizes = {10,100,1000,5000,10000};

        // Loop through different test sizes
        for (int size : testSizes) {
            System.out.println("\nPerformance Test for size: " + size);
            runPerformanceTest(transactionSystem, size);
        }
    }

    // Performance testing method
    private static void runPerformanceTest(TransactionHistorySystem system, int size) {
        long startTime, endTime;

        // Automatically add transactions
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            Transaction newTransaction = new Transaction(i, "12/10/2024", 100.00 + i, "deposit");
            system.transactionStack.push(newTransaction);  // Directly adding transaction to stack
            system.undoStack.push(newTransaction);         // Push to undo stack
        }
        endTime = System.nanoTime();
        System.out.println("Time to add " + size + " transactions: " + (endTime - startTime) + " ns");

        // Access the top transaction (without printing, for timing purposes)
        startTime = System.nanoTime();
        if (!system.transactionStack.isEmpty()) {
            Transaction topTransaction = system.transactionStack.peek();
        }
        endTime = System.nanoTime();
        System.out.println("Time to access top transaction: " + (endTime - startTime) + " ns");

        // Automatically delete a transaction from the middle of the stack
        startTime = System.nanoTime();
        deleteTransactionById(system, size / 2);
        endTime = System.nanoTime();
        System.out.println("Time to delete a transaction: " + (endTime - startTime) + " ns");

        // Test undo operation
        startTime = System.nanoTime();
        system.undo();
        endTime = System.nanoTime();
        System.out.println("Time to undo last transaction: " + (endTime - startTime) + " ns");

        // Test redo operation
        startTime = System.nanoTime();
        system.redo();
        endTime = System.nanoTime();
        System.out.println("Time to redo last transaction: " + (endTime - startTime) + " ns");

        // Measure time to delete all transactions
        startTime = System.nanoTime();
        deleteAllTransactions(system);
        endTime = System.nanoTime();
        System.out.println("Time to delete all transactions: " + (endTime - startTime) + " ns");
    }

    // Method to automatically delete a transaction by ID
    private static void deleteTransactionById(TransactionHistorySystem system, int id) {
        Stack<Transaction> tempStack = new Stack<>();
        boolean found = false;

        // Look for the transaction with the given ID
        while (!system.transactionStack.isEmpty()) {
            Transaction t = system.transactionStack.pop();
            if (t.transactionId == id) {
                system.undoStack.push(t); // Add to undo stack
                system.redoStack.clear(); // Clear redo stack
                found = true;
                break;
            }
            tempStack.push(t); // Store other transactions temporarily
        }

        // Push all other transactions back into the original stack
        while (!tempStack.isEmpty()) {
            system.transactionStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Transaction ID " + id + " not found.");
        }
    }

    // Method to delete all transactions
    private static void deleteAllTransactions(TransactionHistorySystem system) {
        system.transactionStack.clear();  // Clear the transaction stack
        system.undoStack.clear();         // Clear the undo stack
        system.redoStack.clear();         // Clear the redo stack
    }
}
