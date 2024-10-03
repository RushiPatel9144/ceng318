public class Task {
    private TaskID id;
    private TaskName name;
    private TaskPriority priority;
    private TaskDeadline deadline;

    public Task(TaskID id, TaskName name, TaskPriority priority, TaskDeadline deadline) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
    }

    public TaskID getId() {
        return id;
    }

    public TaskName getName() {
        return name;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public TaskDeadline getDeadline() {
        return deadline;
    }

    @Override
    public String toString() {
        return "Task [ID: " + id.getId() + ", Name: " + name.getName() + ", Priority: " + priority.getPriority() + ", Deadline: " + deadline.getDeadline() + "]";
    }
}
