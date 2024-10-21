package Lab6.Task1;

public class Main {
    public static void main(String[] args) {
        TicketSystem ts = new TicketSystem();

        ts.addTicket(new Ticket("001", "John Doe", "Internet not working", "high"));
        ts.addTicket(new Ticket("002", "Jane Smith", "Phone line issue", "low"));
        ts.addTicket(new Ticket("003", "Bob Johnson", "Account setup problem", "mid"));

        System.out.println("Next ticket to process: " + ts.viewNextTicket());
        System.out.println("Processing ticket: " + ts.processTicket());
        System.out.println("Searching for ticket by customer name 'Jane Smith': " + ts.searchTicket("", "Jane Smith"));


    }

}

