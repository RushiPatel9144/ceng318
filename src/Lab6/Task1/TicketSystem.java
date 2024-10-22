package Lab6.Task1;

import java.util.LinkedList;
import java.util.Queue;

public class TicketSystem {
    private Queue<Ticket> queue;

    public TicketSystem() {
        this.queue = new LinkedList<>();
    }

    public void addTicket(Ticket t) {
        if (t.priority.equals("high")) {
            ((LinkedList<Ticket>) queue).addFirst(t);
        } else {
            queue.add(t);
        }
    }

    public Ticket processTicket() {
        return queue.poll();
    }

    public Ticket viewNextTicket() {
        return queue.peek();
    }

    public Ticket searchTicket(int ticketID, String customerName) {
        for (Ticket t : queue) {
            if (t.ticketID == ticketID || t.customerName.equals(customerName)) {
                return t;
            }
        }
        return null;
    }
}
