package EcommerceManagementSystem;

import java.util.LinkedList;

public class NotificationManager {
    private LinkedList<Notification> notifications;

    public NotificationManager() {
        notifications = new LinkedList<>();
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void removeNotification() {
        if (!notifications.isEmpty()) {
            notifications.removeFirst();
        } else {
            System.out.println("No notifications to remove.");
        }
    }

    public Notification searchNotification(int itemId) {
        for (Notification notification : notifications) {
            if (notification.getItemId() == itemId) {
                return notification;
            }
        }
        return null; // Not found
    }

    public void displayNotifications() {
        for (Notification notification : notifications) {
            System.out.println(notification);
        }
    }
}
