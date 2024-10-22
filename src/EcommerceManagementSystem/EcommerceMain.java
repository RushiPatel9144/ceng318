package EcommerceManagementSystem;

import java.util.Scanner;

public class EcommerceMain {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();
        NotificationManager notificationManager = new NotificationManager();
        ReturnManager returnManager = new ReturnManager();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nE-Commerce System Menu:");
            System.out.println("1. Manage Inventory");
            System.out.println("2. Manage Back-in-Stock Notifications");
            System.out.println("3. Manage Return Requests");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageInventory(inventoryManager, scanner);
                    break;
                case 2:
                    manageNotifications(notificationManager, scanner);
                    break;
                case 3:
                    manageReturns(returnManager, scanner);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting E-Commerce System.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private static void manageInventory(InventoryManager inventoryManager, Scanner scanner) {
        System.out.println("\nInventory Management:");
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. Search Item by ID");
        System.out.println("4. Display All Items");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Item ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Item Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Item Price: ");
                double price = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter Item Category: ");
                String category = scanner.nextLine();

                inventoryManager.addItem(new InventoryItem(new ItemID(id), new ItemName(name),
                        new ItemPrice(price), new ItemCategory(category)));
                System.out.println("Item added!");
                break;
            case 2:
                System.out.print("Enter Item ID to remove: ");
                int removeId = scanner.nextInt();
                inventoryManager.removeItem(removeId);
                System.out.println("Item removed!");
                break;
            case 3:
                System.out.print("Enter Item ID to search: ");
                int searchId = scanner.nextInt();
                InventoryItem item = inventoryManager.searchItemById(searchId);
                if (item != null) {
                    System.out.println("Item found: " + item);
                } else {
                    System.out.println("Item not found.");
                }
                break;
            case 4:
                System.out.println("Inventory:");
                inventoryManager.displayInventory();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void manageNotifications(NotificationManager notificationManager, Scanner scanner) {
        System.out.println("\nBack-in-Stock Notification Management:");
        System.out.println("1. Add Notification");
        System.out.println("2. Remove Notification");
        System.out.println("3. Search Notification by Item ID");
        System.out.println("4. Display All Notifications");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Customer Name: ");
                String customer = scanner.nextLine();
                System.out.print("Enter Item ID: ");
                int itemId = scanner.nextInt();
                notificationManager.addNotification(new Notification(customer, itemId));
                System.out.println("Notification added!");
                break;
            case 2:
                notificationManager.removeNotification();
                System.out.println("Notification removed!");
                break;
            case 3:
                System.out.print("Enter Item ID to search: ");
                int searchId = scanner.nextInt();
                Notification notification = notificationManager.searchNotification(searchId);
                if (notification != null) {
                    System.out.println("Notification found: " + notification);
                } else {
                    System.out.println("Notification not found.");
                }
                break;
            case 4:
                System.out.println("Notifications:");
                notificationManager.displayNotifications();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void manageReturns(ReturnManager returnManager, Scanner scanner) {
        System.out.println("\nReturn Request Management:");
        System.out.println("1. Add Return Request");
        System.out.println("2. Process Return Request");
        System.out.println("3. Display All Return Requests");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Customer Name: ");
                String customer = scanner.nextLine();
                System.out.print("Enter Item ID: ");
                int itemId = scanner.nextInt();
                returnManager.addReturnRequest(new ReturnRequest(customer, itemId));
                System.out.println("Return request added!");
                break;
            case 2:
                returnManager.processReturnRequest();
                break;
            case 3:
                System.out.println("Return Requests:");
                returnManager.displayReturnRequests();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }
}
