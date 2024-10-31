package TaskManager;
import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Add task
    public void addTask(TaskID id, TaskName name, TaskPriority priority, TaskDeadline deadline) {
        tasks.add(new Task(id, name, priority, deadline));
    }

    // Remove task by ID
    public void removeTaskByID(int id) {
        tasks.removeIf(task -> task.getId().getId() == id);
    }

    // Remove task by name
    public void removeTaskByName(String name) {
        tasks.removeIf(task -> task.getName().getName().equals(name));
    }

    // Access task at index
    public void accessTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index);
//            System.out.println(tasks.get(index));
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Search task by ID
    public void searchTaskByID(int id) {
        for (Task task : tasks) {
            if (task.getId().getId() == id) {
//                System.out.println(task); for testing
                return;
            }
        }
        System.out.println("Task not found.");
    }

    // Search task by name
    public void searchTaskByName(String name) {
        for (Task task : tasks) {
            if (task.getName().getName().equals(name)) {
//                System.out.println(task); for testing
                return;
            }
        }
        System.out.println("Task not found.");
    }
}
