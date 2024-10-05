package TaskManager;

import java.util.Random;

public class TaskmanagerPerformanceTest {
    public static void main(String[] args) {
        int[] taskCounts = {10,100, 1000, 10000,100000}; // Different scales of tasks
        TaskManager manager;

        for (int count : taskCounts) {
            System.out.println("Performance Testing with " + count + " tasks");

            manager = new TaskManager();
            Random random = new Random();

            // Measure time for adding tasks
            long startTime = System.nanoTime();
            for (int i = 1; i <= count; i++) {
                TaskID id = new TaskID(i);
                TaskName name = new TaskName("Task " + i);
                TaskPriority priority = new TaskPriority(random.nextInt(5) + 1); // Priority from 1 to 5
                TaskDeadline deadline = new TaskDeadline("2024-12-31"); // Example deadline
                manager.addTask(id, name, priority, deadline);
            }
            long endTime = System.nanoTime();
            System.out.printf("Time taken to add %d tasks: %.2f ms%n", count, (endTime - startTime) / 1_000_000.0);

            // Measure time for removing tasks by ID
            startTime = System.nanoTime();
            for (int i = 1; i <= count; i++) {
                manager.removeTaskByID(i);
            }
            endTime = System.nanoTime();
            System.out.printf("Time taken to remove %d tasks by ID: %.2f ms%n", count, (endTime - startTime) / 1_000_000.0);

            // Re-add tasks for access testing
            for (int i = 1; i <= count; i++) {
                TaskID id = new TaskID(i);
                TaskName name = new TaskName("Task " + i);
                TaskPriority priority = new TaskPriority(random.nextInt(5) + 1);
                TaskDeadline deadline = new TaskDeadline("2024-12-31");
                manager.addTask(id, name, priority, deadline);
            }

            // Measure time for accessing tasks
            startTime = System.nanoTime();
            for (int i = 0; i < count; i++) {
                manager.accessTask(i);
            }
            endTime = System.nanoTime();
            System.out.printf("Time taken to access %d tasks: %.2f ms%n", count, (endTime - startTime) / 1_000_000.0);

            // Measure time for searching tasks by ID
            startTime = System.nanoTime();
            for (int i = 1; i <= count; i++) {
                manager.searchTaskByID(i);
            }
            endTime = System.nanoTime();
            System.out.printf("Time taken to search %d tasks by ID: %.2f ms%n", count, (endTime - startTime) / 1_000_000.0);

            // Measure time for searching tasks by name
            startTime = System.nanoTime();
            for (int i = 1; i <= count; i++) {
                manager.searchTaskByName("Task " + i);
            }
            endTime = System.nanoTime();
            System.out.printf("Time taken to search %d tasks by name: %.2f ms%n", count, (endTime - startTime) / 1_000_000.0);

            System.out.println("------------------------------------------------");
        }
    }
}
