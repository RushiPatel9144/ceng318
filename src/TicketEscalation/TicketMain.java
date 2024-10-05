package TicketEscalation;

import java.util.Scanner;

public class TicketMain {
    public static void main(String[] args) {
        TicketManager manager = new TicketManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1: // Add Ticket
                    addTicket(manager, scanner);
                    break;
                case 2: // Remove Ticket
                    removeTicket(manager);
                    break;
                case 3: // Access Ticket
                    accessTicket(manager, scanner);
                    break;
                case 4: // Search Ticket by ID
                    searchTicketById(manager, scanner);
                    break;
                case 5: // Search Ticket by Name
                    searchTicketByName(manager, scanner);
                    break;
                case 6: // Print Escalated Tickets
                    manager.printEscalatedTickets();
                    break;
                case 7: // Remove Old Escalations
                    manager.removeOldEscalations();
                    System.out.println("Old escalated tickets removed if any.");
                    break;
                case 8: // Reprioritize Ticket
                    reprioritizeTicket(manager, scanner);
                    break;
                case 9: // Exit
                    manager.getTicketCount();
                    break;
                case 10:
                    running = false;
                    System.out.println("Exiting Ticket Manager.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("Ticket Manager Menu:");
        System.out.println("1. Add Ticket");
        System.out.println("2. Remove Ticket");
        System.out.println("3. Access Ticket");
        System.out.println("4. Search Ticket by ID");
        System.out.println("5. Search Ticket by Name");
        System.out.println("6. Print Tickets");
        System.out.println("7. Remove Old Escalations");
        System.out.println("8. Reprioritize Ticket");
        System.out.println("9. Count Tickets");
        System.out.println("10. Exit");
    }

    private static void addTicket(TicketManager manager, Scanner scanner) {
        System.out.print("Enter Ticket ID: ");
        TicketID id = new TicketID(scanner.nextInt());
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Customer Name: ");
        TicketCustomerName customerName = new TicketCustomerName(scanner.nextLine());

        System.out.print("Enter Issue Description: ");
        TicketDescription issueDescription = new TicketDescription(scanner.nextLine());

        System.out.print("Enter Priority (1-5, where 1 is highest): ");
        TicketPriority priority = new TicketPriority(scanner.nextInt());
        scanner.nextLine(); // Consume newline

        Ticket ticket = new Ticket(id, customerName, issueDescription, priority);
        manager.addTicket(ticket);
        System.out.println("Ticket added successfully!");
    }

    private static void removeTicket(TicketManager manager) {
        Ticket removedTicket = manager.removeTicket();
        if (removedTicket != null) {
            System.out.println("Removed Ticket: " + removedTicket);
        } else {
            System.out.println("No tickets to remove.");
        }
    }

    private static void accessTicket(TicketManager manager, Scanner scanner) {
        System.out.print("Enter index to access ticket: ");
        int index = scanner.nextInt();
        Ticket ticket = manager.accessTicket(index);
        if (ticket != null) {
            System.out.println("Ticket details: " + ticket);
        } else {
            System.out.println("Invalid index.");
        }
    }

    private static void searchTicketById(TicketManager manager, Scanner scanner) {
        System.out.print("Enter Ticket ID to search: ");
        int id = scanner.nextInt();
        Ticket ticket = manager.searchTicketById(id);
        if (ticket != null) {
            System.out.println("Found Ticket: " + ticket);
        } else {
            System.out.println("Ticket not found.");
        }
    }

    private static void searchTicketByName(TicketManager manager, Scanner scanner) {
        System.out.print("Enter Customer Name to search: ");
        String customerName = scanner.nextLine();
        Ticket ticket = manager.searchTicketByName(customerName);
        if (ticket != null) {
            System.out.println("Found Ticket: " + ticket);
        } else {
            System.out.println("Ticket not found.");
        }
    }

    private static void reprioritizeTicket(TicketManager manager, Scanner scanner) {
        System.out.print("Enter Ticket ID to reprioritize: ");
        int id = scanner.nextInt();
        System.out.print("Enter new priority (1-5): ");
        int newPriorit = scanner.nextInt();
        TicketPriority newPriority = new TicketPriority(newPriorit);
        manager.reprioritizeTicket(id, newPriority);
        System.out.println("Ticket reprioritized.");
    }
}
