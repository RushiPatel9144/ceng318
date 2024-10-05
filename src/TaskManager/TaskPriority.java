package TaskManager;
public class TaskPriority {
    private int priority;  // 1: Low, 2: Medium, 3: High

    public TaskPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
