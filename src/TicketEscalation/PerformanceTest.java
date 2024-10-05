package TicketEscalation;

import java.util.Random;

public class PerformanceTest {
    public static void main(String[] args) {
        int[] ticketCounts = {10,100,1000,10000,100000}; // Different scales of tickets
        TicketManager manager;

        for (int count : ticketCounts) {
            System.out.println("Performance Testing with " + count + " tickets");

            manager = new TicketManager();

            // Measure time for adding tickets
            long startTime = System.nanoTime();
            for (int i = 1; i <= count; i++) {
                Ticket ticket = new Ticket(
                        new TicketID(i),
                        new TicketCustomerName(("Customer " + i)),
                        new TicketDescription("Issue description for customer " + i),
                        new TicketPriority((i % 5) + 1) // Priority from 1 to 5
                );
                manager.addTicket(ticket);
            }
            long endTime = System.nanoTime();
            System.out.printf("Time taken to add %d tickets: %.2f ms%n", count, (endTime - startTime) / 1_000_000.0);

            // Measure time for removing tickets
            startTime = System.nanoTime();
            for (int i = 1; i <= count; i++) {
                manager.removeTicket();
            }
            endTime = System.nanoTime();
            System.out.printf("Time taken to remove %d tickets: %.2f ms%n", count, (endTime - startTime) / 1_000_000.0);

            // Re-add tickets for access testing
            for (int i = 1; i <= count; i++) {
                Ticket ticket = new Ticket(
                        new TicketID(i),
                        new TicketCustomerName("Customer " + i),
                        new TicketDescription("Issue description for customer " + i),
                        new TicketPriority((i % 5) + 1)
                );
                manager.addTicket(ticket);
            }

            // Measure time for accessing tickets
            startTime = System.nanoTime();
            for (int i = 0; i < count; i++) {
                manager.accessTicket(i);
            }
            endTime = System.nanoTime();
            System.out.printf("Time taken to access %d tickets: %.2f ms%n", count, (endTime - startTime) / 1_000_000.0);

            // Measure time for searching tickets by ID
            startTime = System.nanoTime();
            for (int i = 1; i <= count; i++) {
                manager.searchTicketById(i);
            }
            endTime = System.nanoTime();
            System.out.printf("Time taken to search %d tickets by ID: %.2f ms%n", count, (endTime - startTime) / 1_000_000.0);

            // Measure time for searching tickets by customer name
            startTime = System.nanoTime();
            for (int i = 1; i <= count; i++) {
                manager.searchTicketByName("Customer " + i);
            }
            endTime = System.nanoTime();
            System.out.printf("Time taken to search %d tickets by customer name: %.2f ms%n", count, (endTime - startTime) / 1_000_000.0);

            System.out.println("------------------------------------------------");
        }
    }
}
