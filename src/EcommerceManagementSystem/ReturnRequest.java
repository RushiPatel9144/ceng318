package EcommerceManagementSystem;

public class ReturnRequest {
    private String customerName;
    private int itemId;

    public ReturnRequest(String customerName, int itemId) {
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
        return "Return request for customer " + customerName + " for Item ID " + itemId;
    }
}
