package Lab6.Task4;

import java.util.HashMap;
import java.util.Map;

public class Management {
    final Map<Integer, Order> orders = new HashMap<>();

    // 1. Add Order
    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    // 2. Update Order Status
    public void updateOrderStatus(int orderId, String status) {
        if (orders.containsKey(orderId)) {
            Order order = orders.get(orderId);
            order.setStatus(status);
        } else {
            System.out.println("Order not found!");
        }
    }

    // 3. Search Order
    public Order searchOrder(int orderId) {
        return orders.getOrDefault(orderId, null);
    }

}
