package Lab6.Task4;

import java.util.Random;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        Management management = new Management();
        // Adding orders
        // Generating and adding 100 orders
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 1; i <= 10000; i++) {
            int customerId = random.nextInt(1000) + 1; // Random customer ID between 1 and 1000
            String status = getStatus(random.nextInt(3)); // Random status
            management.addOrder(new Order(i, customerId, status));
        }
        long endTime = System.nanoTime();
        System.out.println("Time for adding " + (endTime - startTime) + " ns");

        System.out.println(management.orders);
        // Updating an order status
        long startTime1 = System.nanoTime();
        management.updateOrderStatus(1, "Delivered");
        long endTime1 = System.nanoTime();
        System.out.println("Time for updating " + (endTime1 - startTime1) + " ns");


        // Searching for an order by ID
        long startTime2 = System.nanoTime();
        System.out.println(management.searchOrder(6));
        long endTime2 = System.nanoTime();
        System.out.println("Time for searching " + (endTime2 - startTime2) + " ns");

    }
    private static String getStatus(int statusId) {
        switch (statusId) {
            case 0:
                return "Processing";
            case 1:
                return "Shipped";
            case 2:
                return "Delivered";
            default:
                return "Unknown";
        }
    }

}
/*
For 100 data sets:
Time for adding 1363800 ns
Time for updating 21700 ns
Time for searching 70400 ns


For 1000 data sets:
Time for adding 1862000 ns
Time for updating 23200 ns
Time for searching 79500 ns

For 10000 data sets:
Time for adding 5183500 ns
Time for updating 29000 ns
Time for searching 193500 ns
 */
