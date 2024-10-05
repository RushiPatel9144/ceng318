package TicketEscalation;

import java.util.LinkedList;

public class TicketManager {
    private LinkedList<Ticket> tickets;

    public TicketManager() {
        tickets = new LinkedList<>();
    }

    // Method to add tickets based on priority
    public void addTicket(Ticket ticket) {
        if (ticket.getPriority().getPriority() == 1) { // High priority
            tickets.addFirst(ticket);
        } else if (ticket.getPriority().getPriority() > 2) { // Escalated tickets
            int index = tickets.size() / 2; // Insert in the middle
            tickets.add(index, ticket);
        } else { // Regular tickets
            tickets.addLast(ticket);
        }
    }

    // Method to remove tickets from the front
    public Ticket removeTicket() {
        if (tickets.isEmpty()) {
            return null;
        }
        return tickets.removeFirst(); // Process the ticket from the front
    }

    // Method to access a ticket by index
    public Ticket accessTicket(int index) {
        if (index < 0 || index >= tickets.size()) {
            return null;
        }
        return tickets.get(index);
    }

    // Search by Ticket ID
    public Ticket searchTicketById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId().getId() == id) {
                return ticket;
            }
        }
        return null; // Not found
    }

    // Search by Customer Name
    public Ticket searchTicketByName(String customerName) {
        for (Ticket ticket : tickets) {
            if (ticket.getName().getName().equalsIgnoreCase(customerName)) {
                return ticket;
            }
        }
        return null; // Not found
    }

    // Print escalated tickets
    public void printEscalatedTickets() {
        System.out.println("Escalated Tickets:");
        for (Ticket ticket : tickets) {
            if (ticket.getPriority().getPriority() == 1) {
                System.out.println(ticket);
            }
        }
        System.out.println("Tickets:");
        for (Ticket ticket : tickets) {
                System.out.println(ticket);
        }
    }

    // Remove old escalations
    public void removeOldEscalations() {
        while (!tickets.isEmpty() && tickets.size() > 10) { // Keep at most 10 escalated tickets
            tickets.removeLast();
        }
    }

    // Reprioritize a ticket
    public void reprioritizeTicket(int id, TicketPriority newPriority) {
        for (Ticket ticket : tickets) {
            if (ticket.getId().getId() == id) {
                tickets.remove(ticket);
                Ticket reprioritizedTicket = new Ticket(ticket.getId(), ticket.getName(),
                        ticket.getDescription(), newPriority);
                addTicket(reprioritizedTicket);
                break;
            }
        }
    }

    public void getTicketCount() {
        System.out.println(tickets.size());
    }
}
