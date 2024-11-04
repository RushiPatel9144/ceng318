package lab07.task2;

public class Transaction {
    private Integer transactionID;
    private Integer customerID;
    private String date;
    private Double amount;

    public Transaction(Integer transactionID, Integer customerID, String date, Double amount) {
        this.transactionID = transactionID;
        this.customerID = customerID;
        this.date = date;
        this.amount = amount;
    }

    public Integer getTransactionID() {
        return transactionID;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionID + ", Customer ID: " + customerID +
                ", Date: " + date + ", Amount: $" + amount;
    }
}
