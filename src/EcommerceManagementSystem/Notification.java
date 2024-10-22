package EcommerceManagementSystem;

public class Notification {
    private String customerName;
    private int itemId;

    public Notification(String customerName, int itemId) {
        this.customerName = customerName;
        this.itemId = itemId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getItemId() {
        return itemId;
    }

    @Override
    public String toString() {
        return "Notification for " + customerName + " regarding Item ID " + itemId;
    }
}
