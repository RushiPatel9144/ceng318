package lab07.task1;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree orgTree = new Tree();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Set root employee
        System.out.println("Enter root employee ID (number): ");
        int rootID = scanner.nextInt();
        orgTree.addRoot(new Employee(rootID, "Employee_" + rootID, "Manager", -1)); // Set root employee

        // Ask for the number of employees to add
        System.out.println("Enter the number of employees to add (number only):");
        String input = scanner.next(); // Only expect numeric input
        if (input.equalsIgnoreCase("exit")) {
            return; // Exit the program if "exit" is typed
        }

        int numberOfEmployeesToAdd;
        try {
            numberOfEmployeesToAdd = Integer.parseInt(input); // Parse the number
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }

        // Performance Testing for adding employees
        long startTime = System.nanoTime();
        for (int i = 0; i < numberOfEmployeesToAdd; i++) {
            int employeeID = rootID + i + 1; // Assign a new ID
            String name = "Employee_" + employeeID; // Generate a name
            String position = random.nextBoolean() ? "Manager" : "Employee"; // Randomly assign position

            // Loop to find a valid manager node
            TreeNode managerNode = null;
            for (int attempt = 0; attempt < 10; attempt++) {
                int managerID = random.nextInt(employeeID); // Adjust range to existing employee IDs
                managerNode = orgTree.findEmployee(managerID);
                if (managerNode != null) {
                    break; // Exit loop if a valid manager is found
                }
            }

            // Add the employee under the found manager
            if (managerNode != null) {
                orgTree.addChild(managerNode, new Employee(employeeID, name, position, managerNode.getElement()));
            } else {
                System.out.println("Unable to find a valid manager for employee ID " + employeeID);
            }
        }
        long endTime = System.nanoTime();
        long additionTime = endTime - startTime;
        System.out.println("\nTime taken to add " + numberOfEmployeesToAdd + " employees: " + additionTime + " nanoseconds.");

        // Displaying total employees added (excluding the root employee)
        System.out.println("\nTotal Employees Added: " + numberOfEmployeesToAdd);

        // Display the organizational hierarchy tree
        System.out.println("\n===== Organizational Hierarchy Tree =====");
        orgTree.printTree(orgTree.root(), "", false);

        // Performance Testing for traversals
        for (String order : new String[]{"Preorder", "Inorder", "Postorder"}) {
            startTime = System.nanoTime();

            switch (order) {
                case "Preorder":
                    System.out.println("\nPreorder Traversal:");
                    orgTree.preOrderTraversal(orgTree.root());
                    break;
                case "Inorder":
                    System.out.println("\nInorder Traversal:");
                    orgTree.inOrderTraversal(orgTree.root());
                    break;
                case "Postorder":
                    System.out.println("\nPostorder Traversal:");
                    orgTree.postOrderTraversal(orgTree.root());
                    break;
            }

            endTime = System.nanoTime();
            System.out.println(order + " Traversal Time: " + (endTime - startTime) + " nanoseconds.");
        }

        // Search operation
        System.out.print("\nEnter the employee ID to search for: ");
        int searchID = scanner.nextInt();
        startTime = System.nanoTime();
        TreeNode foundEmployee = orgTree.findEmployee(searchID);
        endTime = System.nanoTime();

        if (foundEmployee != null) {
            System.out.println("Employee with ID " + searchID + " found.");
        } else {
            System.out.println("Employee with ID " + searchID + " not found.");
        }
        System.out.println("Search Time: " + (endTime - startTime) + " nanoseconds.");

        scanner.close();
    }
}
