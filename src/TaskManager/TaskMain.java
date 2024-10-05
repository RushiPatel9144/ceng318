package TaskManager;

import java.util.Scanner;

    public class TaskMain {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Task Manager Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task by ID");
            System.out.println("3. Remove Task by Name");
            System.out.println("4. Access Task by Index");
            System.out.println("5. Search Task by ID");
            System.out.println("6. Search Task by Name");
            System.out.println("7. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline after integer input

            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Task Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Task Priority (1-5): ");
                    int priority = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Task Deadline (YYYY-MM-DD): ");
                    String deadline = scanner.nextLine();

                    // Creating instances of TaskID, TaskName, TaskPriority, and TaskDeadline
                    TaskID taskId = new TaskID(id);
                    TaskName taskName = new TaskName(name);
                    TaskPriority taskPriority = new TaskPriority(priority);
                    TaskDeadline taskDeadline = new TaskDeadline(deadline);

                    // Adding the task
                    manager.addTask(taskId, taskName, taskPriority, taskDeadline);
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Task ID to remove: ");
                    int removeId = scanner.nextInt();
                    manager.removeTaskByID(removeId);
                    System.out.println("Task removed successfully!");
                    break;

                case 3:
                    System.out.print("Enter Task Name to remove: ");
                    String removeName = scanner.nextLine();
                    manager.removeTaskByName(removeName);
                    System.out.println("Task removed successfully!");
                    break;

                case 4:
                    System.out.print("Enter index to access task: ");
                    int index = scanner.nextInt();
                    manager.accessTask(index);
                    break;

                case 5:
                    System.out.print("Enter Task ID to search: ");
                    int searchId = scanner.nextInt();
                    manager.searchTaskByID(searchId);
                    break;

                case 6:
                    System.out.print("Enter Task Name to search: ");
                    String searchName = scanner.nextLine();
                    manager.searchTaskByName(searchName);
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting Task Manager.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
    }