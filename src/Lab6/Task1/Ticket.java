package Lab6.Task1;

public class Ticket {
    int ticketID;
    String customerName;
    String issueDescription;
    String priority;

    public Ticket(int ticketID, String customerName, String issueDescription, String priority) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketID + ", Customer: " + customerName + ", Issue: " + issueDescription + ", Priority: " + priority;
    }
}
