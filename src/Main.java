import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Add tasks for testing
        for (int i = 1; i <= 100; i++) {
            taskManager.addTask(new TaskID(i), new TaskName("Task " + i), new TaskPriority(i % 3), new TaskDeadline("2024-12-31"));
        }

        // Access and remove a few tasks
        taskManager.accessTask(10);
        taskManager.removeTaskByID(10);
        taskManager.removeTaskByName("Task 20");

        // Search task
        taskManager.searchTaskByID(5);
        taskManager.searchTaskByName("Task 50");
    }
}
