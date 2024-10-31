package EcommerceManagementSystem;

public class PerformanceTest {

    public static void main(String[] args) {
        // Test with different sizes: 100, 1,000, 10,000
        int[] testSizes = {10,100,1000,5000,10000};

        for (int size : testSizes) {
            System.out.println("\nPerformance Test for size: " + size);
            testInventoryPerformance(size);
            System.out.println("---------------------------------------------------------------");
            testNotificationPerformance(size);
            System.out.println("---------------------------------------------------------------");
            testReturnRequestPerformance(size);
        }
    }

    // 1. Inventory Management (ArrayList)
    private static void testInventoryPerformance(int size) {
        InventoryManager inventoryManager = new InventoryManager();
        long startTime, endTime;

        // Test adding items
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            inventoryManager.addItem(new InventoryItem(new ItemID(i), new ItemName("Item" + i),
                    new ItemPrice(10.99), new ItemCategory("Category")));
        }
        endTime = System.nanoTime();
        System.out.println("Time to add " + size + " inventory items: " + (endTime - startTime) + " ns");

        // Test searching items by ID
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            inventoryManager.searchItemById(i);
        }
        endTime = System.nanoTime();
        System.out.println("Time to search " + size + " inventory items: " + (endTime - startTime) + " ns");

        // Test removing items
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            inventoryManager.removeItem(i);
        }
        endTime = System.nanoTime();
        System.out.println("Time to remove " + size + " inventory items: " + (endTime - startTime) + " ns");
    }

    // 2. Notification Management (LinkedList)
    private static void testNotificationPerformance(int size) {
        NotificationManager notificationManager = new NotificationManager();
        long startTime, endTime;

        // Test adding notifications
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            notificationManager.addNotification(new Notification("Customer" + i, i));
        }
        endTime = System.nanoTime();
        System.out.println("Time to add " + size + " notifications: " + (endTime - startTime) + " ns");

        // Test searching notifications by item ID
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            notificationManager.searchNotification(i);
        }
        endTime = System.nanoTime();
        System.out.println("Time to search " + size + " notifications: " + (endTime - startTime) + " ns");

        // Test removing notifications
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            notificationManager.removeNotification();
        }
        endTime = System.nanoTime();
        System.out.println("Time to remove " + size + " notifications: " + (endTime - startTime) + " ns");
    }

    // 3. Return Request Management (Stack)
    private static void testReturnRequestPerformance(int size) {
        ReturnManager returnManager = new ReturnManager();
        long startTime, endTime;

        // Test adding return requests
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            returnManager.addReturnRequest(new ReturnRequest("Customer" + i, i));
        }
        endTime = System.nanoTime();
        System.out.println("Time to add " + size + " return requests: " + (endTime - startTime) + " ns");

        // Test processing return requests (LIFO)
        startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            returnManager.processReturnRequest();
        }
        endTime = System.nanoTime();
        System.out.println("Time to process " + size + " return requests: " + (endTime - startTime) + " ns");
    }
}
