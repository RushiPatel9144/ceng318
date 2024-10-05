package TicketEscalation;

import TaskManager.TaskName;

public class Ticket {




    private TicketID id;
    private TicketCustomerName name;
    private TicketDescription description;
    private TicketPriority priority;

    public Ticket(TicketID id, TicketCustomerName name, TicketDescription description, TicketPriority priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    public TicketDescription getDescription() {
        return description;
    }

    public TicketCustomerName getName() {
        return name;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public TicketID getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ticket [ID: " + id.getId() +
                ", Name: " + name.getName() +
                ", Priority: " + priority.getPriority() +
                ", Description: " + description.getDescirption() + "]";
    }
}
