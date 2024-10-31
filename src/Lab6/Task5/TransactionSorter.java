package Lab6.Task5;

import java.util.*;

class Transaction {
    int transactionId;
    Date date;
    double amount;

    public Transaction(int transactionId, Date date, double amount) {
        this.transactionId = transactionId;
        this.date = date;
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId + ", Date: " + date + ", Amount: " + amount;
    }
}

// Traditional Comparator to sort by amount
class AmountComparator implements Comparator<Transaction> {
    @Override
    public int compare(Transaction t1, Transaction t2) {
        return Double.compare(t1.getAmount(), t2.getAmount());
    }
}

public class TransactionSorter {
    public static void main(String[] args) {
        List<Transaction> transactions = generateTransactions(100);
//        List<Transaction> transactions = generateTransactions(1000);
//        List<Transaction> transactions = generateTransactions(10000);

        // Sort using traditional comparator (by amount)
        long startTime = System.nanoTime();
        transactions.sort(new AmountComparator());
        long endTime = System.nanoTime();
        System.out.println("Sorted by Amount (Traditional Comparator): " + (endTime - startTime) + " ns");

        // Lambda sorting by date
        startTime = System.nanoTime();
        transactions.sort((t1, t2) -> t1.getDate().compareTo(t2.getDate()));
        endTime = System.nanoTime();
        System.out.println("Sorted by Date (Lambda Expression): " + (endTime - startTime)  + " ns");
    }

    // Helper method to generate random transactions
    public static List<Transaction> generateTransactions(int count) {
        List<Transaction> transactions = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            transactions.add(new Transaction(i + 1, new Date(System.currentTimeMillis() - random.nextInt(1_000_000_000)), random.nextDouble() * 1000));
        }
        return transactions;
    }
}
/*
For 100 data sets:
Sorted by Amount (Traditional Comparator): 769100 ns
Sorted by Date (Lambda Expression): 683000 ns


For 1000 data sets:
Sorted by Amount (Traditional Comparator): 2337300 ns
Sorted by Date (Lambda Expression): 2271500 ns


For 10000 data sets:
Sorted by Amount (Traditional Comparator): 9920000 ns
Sorted by Date (Lambda Expression): 6652200 ns

 */