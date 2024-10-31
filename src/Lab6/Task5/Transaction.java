package Lab6.Task5;

class Transaction {
    int transactionID;
    int year, month, day; // Using integer values for the date to avoid importing LocalDate.
    double amount;

    public Transaction(int transactionID, int year, int month, int day, double amount) {
        this.transactionID = transactionID;
        this.year = year;
        this.month = month;
        this.day = day;
        this.amount = amount;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public double getAmount() {
        return amount;
    }

    public int[] getDate() {
        return new int[] { year, month, day };
    }

    public void display() {
        System.out.println("Transaction{" + "ID='" + transactionID + '\'' +
                ", Date=" + year + "-" + month + "-" + day +
                ", Amount=" + amount + '}');
    }
}
