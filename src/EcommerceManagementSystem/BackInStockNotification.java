package EcommerceManagementSystem;

public class BackInStockNotification {
    private String customerName;
    private ItemID itemId;

    public BackInStockNotification(String customerName, ItemID itemId) {
        this.customerName = customerName;
        this.itemId = itemId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ItemID getItemId() {
        return itemId;
    }

    @Override
    public String toString() {
        return "BackInStockNotification{" +
                "customerName='" + customerName + '\'' +
                ", itemId=" + itemId.getId() +
                '}';
    }
}
