package Lab6.Task1;

public class Main {
    public static void main(String[] args) {
        TicketSystem ts = new TicketSystem();

        long startTime = System.nanoTime();
        for (int i = 1; i <= 10000; i++) {
            String customerName = "Customer" + i;
            String issue = "Issue description for ticket " + i;
            String priority = (i % 3 == 0) ? "high" : (i % 3 == 1) ? "mid" : "low";
            ts.addTicket(new Ticket(i, customerName, issue, priority));
        }
        long endTime = System.nanoTime();
        System.out.println("Time for adding " + (endTime - startTime) + " ns");



        long startTime1 = System.nanoTime();
        // Viewing the next ticket to process
        System.out.println("Next ticket to process: " + ts.viewNextTicket());
        long endTime1 = System.nanoTime();
        System.out.println("Time for viewing " + (endTime1 - startTime1) + " ns");


        // Processing the next ticket
        long startTime2 = System.nanoTime();
        System.out.println("Processing ticket: " + ts.processTicket());

        long endTime2 = System.nanoTime();
        System.out.println("Time for Processing " + (endTime2 - startTime2) + " ns");

        // Searching for a specific ticket by customer name
        long startTime3 = System.nanoTime();
        System.out.println("Searching for ticket by customer name: " + ts.searchTicket(0, "Customer60"));
        long endTime3 = System.nanoTime();
        System.out.println("Time for searching " + (endTime3 - startTime3) + " ns");

    }
}


