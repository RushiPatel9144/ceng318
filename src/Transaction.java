import java.util.Scanner;
import java.util.Stack;

// Transaction class to represent each transaction
class Transaction {
    int transactionId;
    String date;
    double amount;
    String type;

    public Transaction(int transactionId, String date, double amount, String type) {
        this.transactionId = transactionId;
        this.date = date;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + ", Date: " + date + ", Amount: " + amount + ", Type: " + type;
    }
}

class TransactionHistorySystem {
    Stack<Transaction> transactionStack = new Stack<>();
    Stack<Transaction> undoStack = new Stack<>();
    Stack<Transaction> redoStack = new Stack<>();
    Scanner scanner = new Scanner(System.in);


    public void addTransaction() {
        System.out.println("Enter Transaction ID: ");
        int id = scanner.nextInt();
        System.out.println("Enter Date (MM/DD/YY): ");
        String date = scanner.next();
        System.out.println("Enter Amount: ");
        double amount = scanner.nextDouble();
        System.out.println("Enter Type (deposit/withdrawal): ");
        String type = scanner.next();

        Transaction newTransaction = new Transaction(id, date, amount, type);
        transactionStack.push(newTransaction);
        undoStack.push(newTransaction);
        redoStack.clear(); // Clear redo stack after adding a new transaction
        System.out.println("Transaction added: " + newTransaction);
    }


    public void viewTransactions() {
//        if (transactionStack.isEmpty()) {
//            System.out.println("No transactions available.");
//        } else {
//            System.out.println("Transaction History:");
//            for (Transaction t : transactionStack) {
//                System.out.println(t);
//            }
//        }
        Transaction tempTrans = transactionStack.peek();
        System.out.println(tempTrans);
    }


    public void deleteTransaction() {
        System.out.println("Enter Transaction ID to delete: ");
        int id = scanner.nextInt();

        Stack<Transaction> tempStack = new Stack<>();
        boolean found = false;

        while (!transactionStack.isEmpty()) {
            Transaction t = transactionStack.pop();
            if (t.transactionId == id) {
                undoStack.push(t);
                redoStack.clear();
                System.out.println("Transaction deleted: " + t);
                found = true;
                break;
            }
            tempStack.push(t);
        }

        while (!tempStack.isEmpty()) {
            transactionStack.push(tempStack.pop());
        }

        if (!found) {
            System.out.println("Transaction ID not found.");
        }
    }


    public void undo() {
        if (!undoStack.isEmpty()) {
            Transaction lastTransaction = undoStack.pop();
            redoStack.push(lastTransaction);
            transactionStack.remove(lastTransaction);
            System.out.println("Undo successful. Removed: " + lastTransaction);
        } else {
            System.out.println("No actions to undo.");
        }
    }


    public void redo() {
        if (!redoStack.isEmpty()) {
            Transaction lastUndoneTransaction = redoStack.pop();
            transactionStack.push(lastUndoneTransaction);
            undoStack.push(lastUndoneTransaction);
            System.out.println("Redo successful. Restored: " + lastUndoneTransaction);
        } else {
            System.out.println("No actions to redo.");
        }
    }


    public void start() {
        while (true) {
            System.out.println("\nChoose an action: ");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Update Transaction");
            System.out.println("4. Delete Transaction");
            System.out.println("5. Undo");
            System.out.println("6. Redo");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addTransaction();
                    break;
                case 2:
                    viewTransactions();
                    break;
                case 3:
                    deleteTransaction();
                    break;
                case 4:
                    undo();
                    break;
                case 5:
                    redo();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        TransactionHistorySystem system = new TransactionHistorySystem();
        system.start();
    }
}
