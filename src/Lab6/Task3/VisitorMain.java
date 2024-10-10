package Lab6.Task3;

import java.util.Scanner;

public class VisitorMain {


    public static void main(String[] args){
        VisitorManager manager = new VisitorManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {

            printMenuH();

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addVisitor(manager,scanner);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
        }
    }


    }
    private static void printMenuH() {
        System.out.println("Visitor Manager Menu:");
        System.out.println("1. Add Visitor");
        System.out.println("2. Remove Visitor");
        System.out.println("3. Check Visitor");
        System.out.println("4. List all Visitor");
        System.out.println("5. Exit");
    }

    private static void addVisitor(VisitorManager manager, Scanner scanner){
        System.out.print("Enter Visitor ID: ");
        Integer visitorID = scanner.nextInt();

        System.out.print("Enter Visitor IP Address: ");
        String visitorIPAddress = scanner.nextLine();

        Visitor visitor = new Visitor(visitorID,visitorIPAddress);
        manager.addVisitor(visitor);
        System.out.println(visitor);


    }
}
