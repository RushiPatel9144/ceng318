package EcommerceManagementSystem;

import java.util.ArrayList;

public class InventoryManager {
    private ArrayList<InventoryItem> inventory;

    public InventoryManager() {
        inventory = new ArrayList<>();
    }

    public void addItem(InventoryItem item) {
        inventory.add(item);
    }

    public void removeItem(int itemId) {
        inventory.removeIf(item -> item.getId().getId() == itemId);
    }

    public InventoryItem searchItemById(int itemId) {
        for (InventoryItem item : inventory) {
            if (item.getId().getId() == itemId) {
                return item;
            }
        }
        return null; // Not found
    }

    public void displayInventory() {
        for (InventoryItem item : inventory) {
            System.out.println(item);
        }
    }
}
